package com.gerenciamento.api.dto;

import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private Integer priceInCents;

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
}
