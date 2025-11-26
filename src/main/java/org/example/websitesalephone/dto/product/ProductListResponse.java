package org.example.websitesalephone.dto.product;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.example.websitesalephone.entity.Inventory;
import org.example.websitesalephone.entity.Product;
import org.example.websitesalephone.entity.ProductVariant;

import java.math.BigDecimal;

@Data
@Builder
@FieldNameConstants
public class ProductListResponse {

    private String productName;

    private String originName;

    private BigDecimal price;

    private int quantity;

    private int quantityUnitSold;

    private String status;

    public static ProductListResponse fromEntity(ProductVariant entity) {
        return ProductListResponse
                .builder()
                .productName(entity.getProduct().getName())
                .originName(entity.getOrigin().getName())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .quantityUnitSold(entity.getQuantityUnitSold())
                .status(entity.getProduct().getStatus().getCode())
                .build();
    }

}
