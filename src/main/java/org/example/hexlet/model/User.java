package org.example.hexlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
public final class User {
    private long id;

    @ToString.Include
    private String first_name;
    private String last_name;
    private String email;

    public User(long id, String first_name, String last_name, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }
    public String getName() {
        return this.first_name + " " + this.last_name;
    }
}
