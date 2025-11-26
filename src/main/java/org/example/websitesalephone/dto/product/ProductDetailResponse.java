package org.example.websitesalephone.dto.product;

import lombok.Builder;
import lombok.Getter;
import org.example.websitesalephone.entity.Inventory;
import org.example.websitesalephone.entity.Product;
import org.example.websitesalephone.entity.ProductImage;
import org.example.websitesalephone.entity.ProductVariant;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductDetailResponse {

    private String productName;

    private String description;

    private int quantity;

    private BigDecimal price;

    private String colorName;

    private String cameraName;

    private String batteryName;

    private String cpuName;

    private String imageName;

    private String screenName;

    private String originName;

    private String storageName;

    private String operatorName;

    private String ramName;

    public static ProductDetailResponse fromEntity(Product product, ProductVariant productVariant, ProductImage productImage) {
        if (product == null || productVariant == null) {
            return null;
        }

        return ProductDetailResponse.builder()
                .productName(product.getName())
                .description(product.getDescription())
                .quantity(productVariant.getQuantity())
                .price(productVariant.getPrice())
                .colorName(productVariant.getColor() != null ? productVariant.getColor().getName() : null)
                .cameraName(productVariant.getCamera() != null ? productVariant.getCamera().getName() : null)
                .batteryName(productVariant.getBattery() != null ? productVariant.getBattery().getName() : null)
                .cpuName(productVariant.getCpu() != null ? productVariant.getCpu().getName() : null)
                .imageName(productImage.getUrl() != null ? productImage.getUrl() : null)
                .screenName(productVariant.getScreen() != null ? productVariant.getScreen().getName() : null)
                .originName(productVariant.getOrigin() != null ? productVariant.getOrigin().getName() : null)
                .storageName(productVariant.getStorage() != null ? productVariant.getStorage().getName() : null)
                .operatorName(productVariant.getOperatingSystem() != null ? productVariant.getOperatingSystem().getName() : null)
                .ramName(productVariant.getRam() != null ? productVariant.getRam().getName() : null)
                .build();
    }

}
