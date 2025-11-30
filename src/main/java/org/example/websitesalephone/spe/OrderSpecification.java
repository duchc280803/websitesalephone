package org.example.websitesalephone.spe;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.example.websitesalephone.dto.order.OrderSearch;
import org.example.websitesalephone.entity.Order;
import org.example.websitesalephone.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecification {

    public static Specification<Order> search(OrderSearch search) {
        return (root, query, cb) -> {

            if (search.getSearchText() == null) return cb.conjunction();

            String text = search.getSearchText();

            Join<Order, User> userJoin = root.join("user", JoinType.LEFT);

            return cb.or(
                    cb.like(root.get("orderCode"), text),
                    cb.like(userJoin.get("fullName"), text),
                    cb.like(userJoin.get("phone"), text)
            );
        };
    }
}
