package org.example.websitesalephone.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "screen")
public class Screen extends BaseEntity{

    @Id
    @Column(length = 50)
    private String id;

    @Column(length = 255)
    private String name;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<ProductVariant> productVariants;
}
