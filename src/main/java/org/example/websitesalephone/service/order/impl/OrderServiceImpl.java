package org.example.websitesalephone.service.order.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.dto.order.OrderDetailResponse;
import org.example.websitesalephone.dto.order.OrderRequest;
import org.example.websitesalephone.dto.order.OrderResponse;
import org.example.websitesalephone.dto.order.OrderSearch;
import org.example.websitesalephone.entity.Order;
import org.example.websitesalephone.entity.OrderDescription;
import org.example.websitesalephone.enums.OrderStatus;
import org.example.websitesalephone.repository.OrderDescriptionRepository;
import org.example.websitesalephone.repository.OrderRepository;
import org.example.websitesalephone.service.order.OrderService;
import org.example.websitesalephone.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderDescriptionRepository orderDescriptionRepository;

    @Override
    public CommonResponse search(OrderSearch searchForm) {
        if (Strings.isNotEmpty(searchForm.getSearchText())) {
            searchForm.setSearchText("%" + searchForm.getSearchText() + "%");
        } else {
            searchForm.setSearchText(null);
        }

        PageRequest pageRequest = Utils.getPaging(searchForm);

        Page<OrderResponse> result = orderRepository.findAll(pageRequest).map(OrderResponse::fromOrder);

        return CommonResponse
                .builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(result)
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
        Order order = orderRepository.findById(orderRequest.getId()).orElse(null);
        OrderDescription orderDescription = new OrderDescription();
        if (order == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_SUCCESS)
                    .message("Order not found")
                    .build();
        }
        OrderStatus newStatus;
        try {
            newStatus = OrderStatus.valueOf(orderRequest.getStatus().toUpperCase());
        } catch (IllegalArgumentException e) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("Invalid order status")
                    .build();
        }
        switch (newStatus) {
            case PENDING:
                order.setStatus(OrderStatus.PENDING.getCode());
                order.setShippingFee(orderRequest.getShippingFee());
                break;
            case CONFIRMED:
                order.setStatus(OrderStatus.CONFIRMED.getCode());
                break;
            case SHIPPING:
                order.setStatus(OrderStatus.SHIPPING.getCode());
                break;
            case DELIVERED:
                order.setStatus(OrderStatus.DELIVERED.getCode());
                break;
            case COMPLETED:
                order.setStatus(OrderStatus.COMPLETED.getCode());
                break;
            case CANCELLED:
                order.setStatus(OrderStatus.CANCELLED.getCode());
                break;
            default:
                return CommonResponse.builder()
                        .code(CommonResponse.CODE_NOT_FOUND)
                        .message("Unsupported order status")
                        .build();
        }
        orderRepository.saveAndFlush(order);

        orderDescription.setOrder(order);
        orderDescription.setDescription(orderRequest.getDescription());

        orderDescriptionRepository.saveAndFlush(orderDescription);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .message("Cập nhật trạng thái đơn hàng thành công")
                .data(OrderResponse.fromOrder(order))
                .build();
    }
}
