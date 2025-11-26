package org.example.websitesalephone.dto.cart;

import lombok.Getter;

@Getter
public class CartRequest {
    private String productId;
    private int quantity;
}
