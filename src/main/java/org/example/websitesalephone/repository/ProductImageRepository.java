package org.example.websitesalephone.repository;

import org.example.websitesalephone.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, String> {

    List<ProductImage> findByProduct_id(String productId);

    @Modifying
    @Query("UPDATE ProductImage pi SET pi.active = false WHERE pi.product.id = :productId")
    void setInactiveAllByProductId(@Param("productId") String productId);

}
