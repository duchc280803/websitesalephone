package org.example.websitesalephone.repository;

import org.example.websitesalephone.entity.OrderDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDescriptionRepository extends JpaRepository<OrderDescription, String> {
}
