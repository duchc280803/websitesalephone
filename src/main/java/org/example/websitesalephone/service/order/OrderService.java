package org.example.websitesalephone.service.order;

import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.dto.order.OrderByUserRequest;
import org.example.websitesalephone.dto.order.OrderRequest;
import org.example.websitesalephone.dto.order.OrderSearch;

public interface OrderService {

    CommonResponse search(OrderSearch orderSearch);

    CommonResponse detail(String id);

    CommonResponse update(OrderRequest orderRequest);

    CommonResponse getListHistory(String id);

    CommonResponse getListOrderByUser(OrderByUserRequest orderByUserRequest);
}
