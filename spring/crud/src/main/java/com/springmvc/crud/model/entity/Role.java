package com.springmvc.crud.model.entity;

import com.springmvc.crud.model.enums.UserRolesEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    private Long id;
    private UserRolesEnum role;
    private String name;

    public Role() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public UserRolesEnum getRole() {
        return role;
    }

    public void setRole(UserRolesEnum role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
