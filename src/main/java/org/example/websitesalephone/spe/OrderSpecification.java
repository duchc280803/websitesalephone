package org.example.websitesalephone.spe;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.example.websitesalephone.dto.order.OrderSearch;
import org.example.websitesalephone.entity.Order;
import org.example.websitesalephone.entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class OrderSpecification {

    public static Specification<Order> search(OrderSearch search) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (search.getStatus() != null && !search.getStatus().isEmpty()) {
                predicates.add(cb.equal(root.get("status"), search.getStatus()));
            }

            if (search.getSearchText() != null && !search.getSearchText().isEmpty()) {
                String text = "%" + search.getSearchText() + "%";

                Join<Order, User> userJoin = root.join("customer", JoinType.LEFT);

                predicates.add(
                        cb.or(
                                cb.like(root.get("orderCode"), text),
                                cb.like(userJoin.get("fullName"), text),
                                cb.like(userJoin.get("phone"), text)
                        )
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

