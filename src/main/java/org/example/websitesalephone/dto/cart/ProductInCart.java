package org.example.websitesalephone.dto.cart;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductInCart {

    private String productId;

    private String productName;

    private int quantity;

    private String ram;

    private String color;

    private String ops;

    private String image;

    private BigDecimal price;
}
