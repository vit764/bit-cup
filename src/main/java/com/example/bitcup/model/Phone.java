package com.example.bitcup.model;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
public class Phone extends SimpleEntity{
    @Column(name = "VALUE", nullable = false, insertable = true, updatable = true)
    private String value;
    @ManyToOne(fetch = FetchType.LAZY)
    private Workplace workplace;

    @Enumerated(EnumType.STRING)
    private Type type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public enum Type {
        INTERNAL,
        EXTERNAL
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
