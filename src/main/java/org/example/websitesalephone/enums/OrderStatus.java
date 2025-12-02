package org.example.websitesalephone.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PENDING("PENDING", "Chờ xử lý", "⏳"),
    CONFIRMED("CONFIRMED", "Xác nhận", "✅"),
    SHIPPING("SHIPPING", "Đang giao", "📦"),
    DELIVERED("DELIVERED", "Đã giao", "🏠"),
    COMPLETED("COMPLETED", "Hoàn thành", "⭐"),
    CANCELLED("CANCELLED", "hủy", "Huyr");

    private final String code;
    private final String description;
    private final String icon;
}
