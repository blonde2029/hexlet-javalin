package org.example.hexlet;

import io.javalin.Javalin;
import java.util.Collections;
import java.util.List;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursePage;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        var courses = List.of(new Course( "Java", "Java development"),
                new Course( "PHP", "PHP development"),
                new Course( "JS", "Java Script development"));
        app.get("/courses", ctx -> {
            var header = "Development courses";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            var course = courses.get(id);//new Course("Java", "Java development");/* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });


        app.start(7070);
    }
}
