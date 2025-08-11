package com.gerenciamento.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "pessoas")
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String name;
    private LocalDate age;
    private String email;
    private Boolean active;

    public String getId() { return id;}

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge() { return age;}

    public void setAge(LocalDate age) { this.age = age;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email;}

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

