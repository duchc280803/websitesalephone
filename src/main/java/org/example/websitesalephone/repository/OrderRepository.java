package org.example.websitesalephone.repository;

import org.example.websitesalephone.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Page<Order> findAll(Specification<Order> spec, Pageable pageable);
    List<Order> findAll(Specification<Order> spec);
}
