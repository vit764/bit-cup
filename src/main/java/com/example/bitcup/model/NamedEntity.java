package com.example.bitcup.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity extends SimpleEntity {

    @Column(name = "NAME", nullable = false, insertable = true, updatable = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
