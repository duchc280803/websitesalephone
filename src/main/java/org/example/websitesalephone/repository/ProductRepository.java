package org.example.websitesalephone.repository;

import org.example.websitesalephone.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
}
