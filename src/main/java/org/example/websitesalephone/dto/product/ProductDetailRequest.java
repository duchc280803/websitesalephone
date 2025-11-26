package org.example.websitesalephone.dto.product;

import lombok.Getter;

@Getter
public class ProductDetailRequest {

    private String idProduct;

    private String idProductVariant;

    private String productImageId;

    private String inventoryId;
}
