package com.nexia.nexia.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ManyToMany(targetEntity = DyslexiaType.class)
    @JoinTable(name = "user_dyslexia_types", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "dyslexia_type_id"))
    private List<DyslexiaType> dyslexia_types;

    public User(Long id, String username, List<DyslexiaType> dyslexia_types) {
        this.id = id;
        this.username = username;
        this.dyslexia_types = dyslexia_types;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<DyslexiaType> getDyslexia_types() {
        return dyslexia_types;
    }

    public void setDyslexia_types(List<DyslexiaType> dyslexia_types) {
        this.dyslexia_types = dyslexia_types;
    }
}
