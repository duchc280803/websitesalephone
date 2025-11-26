package org.example.websitesalephone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_description")
@Getter
@Setter
@NoArgsConstructor
public class OrderDescription extends  BaseEntity{

    @Id
    private String id;

    @Column(nullable = false, length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
