package com.example.bitcup.model;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account extends SimpleEntity {
    @Column(name = "LOGIN", nullable = false, insertable = true, updatable = true)
    private String login;
    @Column(name = "PASSWORD", nullable = false, insertable = true, updatable = true)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER,
        ADMIN
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
