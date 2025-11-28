package org.example.websitesalephone.dto.product;

import lombok.Builder;
import lombok.Getter;
import org.example.websitesalephone.entity.ProductVariant;

@Getter
@Builder
public class ProductVariantResponse {

    private String idProduct;

    private int quantity;

    public static ProductVariantResponse from(ProductVariant productVariant) {
        return ProductVariantResponse
                .builder()
                .idProduct(productVariant.getId())
                .quantity(productVariant.getQuantity())
                .build();
    }
}
