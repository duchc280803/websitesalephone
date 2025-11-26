package org.example.websitesalephone.dto.order;

import lombok.Builder;
import lombok.Getter;
import org.example.websitesalephone.entity.Address;
import org.example.websitesalephone.entity.Order;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Builder
public class OrderDetailResponse {

    private String orderCode;

    private OffsetDateTime createdAt;

    private String status;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String methodTransaction;

    private BigDecimal totalPrice;

    private String statusTransaction;

    private List<ProductOrderResponse> productOrderResponses;

    private List<OrderHistoryStatusResponse> orderHistoryStatusResponses;

    public static OrderDetailResponse fromEntity(Order order) {

        List<ProductOrderResponse> productOrderResponses = order.getOrderItems().stream()
                .map(item -> {
                    ProductOrderResponse productDTO = new ProductOrderResponse();
                    productDTO.setProductName(item.getProductVariant().getProduct().getName());
                    productDTO.setProductPrice(item.getUnitPrice());
                    productDTO.setQuantity(item.getQuantity());
                    productDTO.setIntoMoney(item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
                    return productDTO;
                })
                .toList();

        BigDecimal totalPrice = productOrderResponses.stream()
                .map(ProductOrderResponse::getIntoMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<OrderHistoryStatusResponse> orderHistoryStatusResponseList = order.getStatusHistories()
                .stream().map(item -> {
                    OrderHistoryStatusResponse orderHistoryStatusResponse = new OrderHistoryStatusResponse();
                    orderHistoryStatusResponse.setStatus(item.getStatus());
                    orderHistoryStatusResponse.setChangedAt(item.getChangedAt());
                    return orderHistoryStatusResponse;
                }).toList();

        return OrderDetailResponse.builder()
                .orderCode(order.getOrderCode())
                .createdAt(order.getCreatedAt())
                .status(order.getStatus() != null ? order.getStatus() : null)
                .fullName(order.getUser() != null ? order.getUser().getFullName() : null)
                .phoneNumber(order.getUser() != null ? order.getUser().getPhone() : null)
                .address(order.getUser() != null ? order.getAddressDetail() : null)
                .methodTransaction(order.getMethodTransaction())
                .totalPrice(totalPrice)
                .statusTransaction(order.getStatusTransaction())
                .productOrderResponses(productOrderResponses)
                .orderHistoryStatusResponses(orderHistoryStatusResponseList)
                .build();
    }

    public String getAddress(Address address) {
        return address.getDistrict() + " " + address.getCity();
    }

}
