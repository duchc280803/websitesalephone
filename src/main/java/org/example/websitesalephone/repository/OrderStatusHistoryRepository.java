package org.example.websitesalephone.repository;

import org.example.websitesalephone.entity.OrderStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusHistoryRepository extends JpaRepository<OrderStatusHistory, String> {
}
