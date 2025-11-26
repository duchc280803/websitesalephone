package org.example.websitesalephone.dto.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductRequest {

    private String productName;

    private String description;

    private int quantity;

    private BigDecimal price;

    private String productVariantId;

    private String productId;

    private String colorId;

    private String cameraId;

    private String batteryId;

    private String cpuId;

    private String imageId;

    private String screenId;

    private String originId;

    private String storageId;

    private String supplierId;

    private String operatorId;

    private String ramId;
}
