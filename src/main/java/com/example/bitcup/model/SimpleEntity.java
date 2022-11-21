package com.example.bitcup.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class SimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = false)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
