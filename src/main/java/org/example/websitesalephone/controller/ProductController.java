package org.example.websitesalephone.controller;

import lombok.RequiredArgsConstructor;
import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.dto.product.ProductDetailRequest;
import org.example.websitesalephone.dto.product.ProductRequest;
import org.example.websitesalephone.dto.product.ProductSearch;
import org.example.websitesalephone.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("search")
    public CommonResponse getALl(@RequestBody ProductSearch productSearch) {
        return productService.getALl(productSearch);
    }

    @PostMapping("create")
    public CommonResponse created(@RequestBody ProductRequest productRequest) {
        return productService.created(productRequest);
    }

    @PutMapping("update")
    public CommonResponse update(@RequestBody ProductRequest productRequest) {
        return productService.updated(productRequest);
    }

    @PutMapping("deleted/{id}")
    public CommonResponse deleted(@PathVariable(name = "id") String id) {
        return productService.deleted(id);
    }

    @GetMapping("detail")
    public CommonResponse detail(@RequestBody ProductDetailRequest productDetailRequest) {
        return productService.detail(productDetailRequest);
    }
}
