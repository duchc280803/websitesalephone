package org.example.websitesalephone.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.websitesalephone.entity.Order;
import org.example.websitesalephone.entity.OrderItem;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
public class OrderResponse {

    private String order_id;

    private String orderCode;

    private String userName;

    private String phone;

    private OffsetDateTime createdAt;

    private OffsetDateTime dateTimeCheckout;

    private int quantity;

    private String status;

    private BigDecimal totalPrice;

    private BigDecimal shippingFee;

    private BigDecimal totalOrderAmount;

    public static OrderResponse fromOrder(final Order order) {

        int totalQuantity = order.getOrderItems().stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();

        BigDecimal totalPrice = order.getOrderItems().stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalOrderAmount = totalPrice.add(order.getShippingFee() != null ? order.getShippingFee() : BigDecimal.ZERO);

        return OrderResponse.builder()
                .order_id(order.getId() != null ? order.getId() : null)
                .orderCode(order.getOrderCode())
                .userName(order.getUser() != null ? order.getUser().getFullName() : null)
                .phone(order.getUser() != null ? order.getUser().getPhone() : null)
                .createdAt(order.getCreatedAt())
                .dateTimeCheckout(order.getDateTimeCheckout())
                .quantity(totalQuantity)
                .status(order.getStatus() != null ? order.getStatus() : null)
                .totalPrice(totalPrice)
                .shippingFee(order.getShippingFee())
                .totalOrderAmount(totalOrderAmount)
                .build();
    }

}
