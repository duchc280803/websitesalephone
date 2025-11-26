package org.example.websitesalephone.repository;

import org.example.websitesalephone.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
