package org.example.websitesalephone.service.product;

import org.example.websitesalephone.dto.dynamic.CreateCartRequest;
import org.example.websitesalephone.dto.product.ProductDetailRequest;
import org.example.websitesalephone.dto.product.ProductRequest;
import org.example.websitesalephone.dto.product.ProductSearch;
import org.example.websitesalephone.comon.CommonResponse;

public interface ProductService {

    CommonResponse getALl(ProductSearch productSearch);

    CommonResponse created(ProductRequest productRequest);

    CommonResponse updated(ProductRequest productRequest);

    CommonResponse detail(ProductDetailRequest productDetailRequest);

    CommonResponse deleted(String id);

    CommonResponse getQuantity(CreateCartRequest createCartRequest);
}
