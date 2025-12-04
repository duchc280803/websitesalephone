package org.example.websitesalephone.dto.product;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.example.websitesalephone.entity.Product;
import org.example.websitesalephone.entity.ProductVariant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
@Builder
@FieldNameConstants
public class ProductListResponse {

    private String id;

    private String productName;

    private String originName;

    private BigDecimal price;

    private int quantity;

    private String status;

    private List<ProductImageResponse> responseList;

    public static ProductListResponse fromEntity(Product entity) {
        int totalQuantity = entity.getVariants().stream()
                .mapToInt(ProductVariant::getQuantity)
                .sum();
        BigDecimal averagePrice = BigDecimal.ZERO;

        if (!entity.getVariants().isEmpty()) {
            averagePrice = entity.getVariants().stream()
                    .map(ProductVariant::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .divide(new BigDecimal(entity.getVariants().size()), 2, RoundingMode.HALF_UP);
        }

        return ProductListResponse.builder()
                .id(entity.getId())
                .productName(entity.getName())
                .originName(entity.getVariants().isEmpty() ? null
                        : entity.getVariants().getFirst().getOrigin().getName())
                .price(averagePrice)
                .quantity(totalQuantity)
                .status(entity.getStatus().getCode())
                .build();
    }
}
