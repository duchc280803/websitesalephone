package org.example.websitesalephone.dto.cart;

import lombok.Builder;
import lombok.Getter;
import org.example.websitesalephone.entity.Cart;
import org.example.websitesalephone.entity.CartItem;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class CartResponse {

    private List<ProductInCart> products;

    private int totalQuantity;

    private BigDecimal total;

    public static CartResponse fromCart(Cart cart) {

        List<ProductInCart> productList = cart.getCartItems().stream()
                .map(item -> ProductInCart.builder()
                        .productId(item.getProductVariant().getId())
                        .productName(item.getProductVariant().getProduct().getName())
                        .quantity(item.getQuantity())
                        .ram(item.getProductVariant().getRam().getName())
                        .color(item.getProductVariant().getColor().getName())
                        .ops(item.getProductVariant().getOperatingSystem().getName())
                        .image(item.getProductVariant().getProduct().getImages().getFirst().getUrl())
                        .price(item.getProductVariant().getPrice())
                        .build())
                .toList();

        int totalQuantity = cart.getCartItems().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();

        BigDecimal total = cart.getCartItems().stream()
                .map(item -> item.getProductVariant().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return CartResponse.builder()
                .products(productList)
                .totalQuantity(totalQuantity)
                .total(total)
                .build();
    }

}
