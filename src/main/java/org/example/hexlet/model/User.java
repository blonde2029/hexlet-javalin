package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
public final class User {
    private Long id;

    @ToString.Include
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
