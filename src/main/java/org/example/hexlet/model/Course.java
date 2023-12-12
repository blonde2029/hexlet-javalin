package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class Course {
    private Long id;

    @ToString.Include
    private String title;
    private String description;

    public Course(String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}