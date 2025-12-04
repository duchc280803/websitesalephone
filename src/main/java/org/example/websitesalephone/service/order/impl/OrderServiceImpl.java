package org.example.websitesalephone.service.order.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.example.websitesalephone.auth.UserDetail;
import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.comon.PageResponse;
import org.example.websitesalephone.dto.order.*;
import org.example.websitesalephone.entity.Order;
import org.example.websitesalephone.entity.OrderStatusHistory;
import org.example.websitesalephone.entity.User;
import org.example.websitesalephone.enums.OrderStatus;
import org.example.websitesalephone.repository.OrderRepository;
import org.example.websitesalephone.repository.OrderStatusHistoryRepository;
import org.example.websitesalephone.repository.UserRepository;
import org.example.websitesalephone.service.order.OrderService;
import org.example.websitesalephone.spe.OrderSpecification;
import org.example.websitesalephone.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderStatusHistoryRepository orderStatusHistoryRepository;

    private final UserRepository userRepository;

    @Override
    public CommonResponse search(OrderSearch searchForm) {

        if (Strings.isNotEmpty(searchForm.getSearchText())) {
            searchForm.setSearchText("%" + searchForm.getSearchText() + "%");
        } else {
            searchForm.setSearchText(null);
        }

        PageRequest pageRequest = Utils.getPaging(searchForm);

        Specification<Order> spec = OrderSpecification.search(searchForm);

        Page<OrderResponse> result = orderRepository
                .findAll(spec, pageRequest)
                .map(OrderResponse::fromOrder);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(PageResponse.from(result))
                .build();
    }

    @Override
    public CommonResponse detail(String id) {
        Order order = orderRepository.findById(id).orElse(null);

        if (order == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_SUCCESS)
                    .message("Order not found")
                    .build();
        }
        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(OrderDetailResponse.fromEntity(order))
                .build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResponse update(OrderRequest orderRequest) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();

        User loginUser = userRepository.findByUsernameAndIsDeleted(userDetail.getLoginId(), false)
                .orElse(null);

        if (loginUser == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("User not found")
                    .build();
        }

        Order order = orderRepository.findById(orderRequest.getId()).orElse(null);

        if (order == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Order not found")
                    .build();
        }

        OrderStatus currentStatus = OrderStatus.fromCode(order.getStatus());

        OrderStatus newStatus;

        // ❗ CASE ĐẶC BIỆT: nếu client yêu cầu CANCELLED → cho phép
        if (Objects.equals(orderRequest.getStatus(), OrderStatus.CANCELLED.getCode())) {
            newStatus = OrderStatus.CANCELLED;

        } else {
            // ❗ Các trạng thái khác → KHÔNG dùng request, backend tự set đúng step tiếp theo
            int nextStep = currentStatus.getStep() + 1;
            newStatus = OrderStatus.fromStep(nextStep);
        }

        // Cập nhật trạng thái
        order.setStatus(newStatus.getCode());

        // Nếu PENDING → CONFIRMED thì có thể update shippingFee
        if (newStatus == OrderStatus.CONFIRMED && orderRequest.getShippingFee() != null) {
            order.setShippingFee(orderRequest.getShippingFee());
        }

        if (newStatus == OrderStatus.COMPLETED) {
            order.setDateTimeCheckout(OffsetDateTime.now());
        }

        order.setStaff(loginUser);
        orderRepository.saveAndFlush(order);

        // Lưu mô tả
        OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
        orderStatusHistory.setId(UUID.randomUUID().toString());
        orderStatusHistory.setOrder(order);
        orderStatusHistory.setDescription(orderRequest.getDescription());
        orderStatusHistory.setStatus(order.getStatus());
        orderStatusHistoryRepository.saveAndFlush(orderStatusHistory);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .message("Cập nhật trạng thái đơn hàng thành công")
                .data(OrderResponse.fromOrder(order))
                .build();
    }

    @Override
    public CommonResponse getListHistory(String id) {
        List<OrderStatusHistory> statusHistories = orderStatusHistoryRepository.findByOrder_id(id);

        if (statusHistories.isEmpty()) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .data(new ArrayList<>())
                    .build();
        }

        List<OrderStatusHistoryResponse> orderStatusHistoryResponses =
                statusHistories.stream().map(OrderStatusHistoryResponse::from).toList();

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(orderStatusHistoryResponses)
                .build();
    }

}
