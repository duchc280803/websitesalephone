package org.example.websitesalephone.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductOrderResponse {

    private String productName;

    private BigDecimal productPrice;

    private int quantity;

    private BigDecimal intoMoney;

}
