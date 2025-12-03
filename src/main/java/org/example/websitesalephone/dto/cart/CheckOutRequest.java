package org.example.websitesalephone.dto.cart;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckOutRequest {

    private String phone;

    private String addressLine;

    private String city;

    private String district;

    private String postalCode;

}
