package com.gerenciamento.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(name = "price_in_cents")
    private Integer priceInCents;
    private Boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
