package org.example.hexlet;

import io.javalin.Javalin;
import java.util.Collections;
import java.util.List;

import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.User;

public class HelloWorld {
    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.parseInt(port);
    }
    public static void main(String[] args) {
        var app = getApp();
        app.start(getPort());
//        var app = Javalin.create(config -> {
//            config.plugins.enableDevLogging();
//        });
//        var courses = List.of(new Course( "Java", "Java development"),
//                new Course( "PHP", "PHP development"),
//                new Course( "JS", "Java Script development"));
//        app.get("/courses", ctx -> {
//            var header = "Development courses";
//            var page = new CoursesPage(courses, header);
//            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
//        });
//
//        app.get("/courses/{id}", ctx -> {
//            var id = Integer.parseInt(ctx.pathParam("id"));
//            var course = courses.get(id);//new Course("Java", "Java development");/* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */
//            var page = new CoursePage(course);
//            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
//        });
//
//
//        app.start(7070);
    }
    public static Javalin getApp() {
        var coursesList = List.of(new Course( 0, "Java", "Java development"),
                new Course( 1,"PHP", "PHP development"),
                new Course( 2, "JS", "Java Script development"));

        var usersList = List.of(new User(0,"Ibvan", "Mamontovich", "IbvMam@yandex.ru"),
                new User(1,"Petr","Petrov", "pp@gmail.com"),
                new User(2,"Sasha", "Cherepanov", "blonde@yandex.ru"));

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/", ctx -> {
            ctx.render("layout/page.jte");
        });

        //users
        app.get("/users",ctx -> {
            var users = new UsersPage(usersList);
            ctx.render("users/index.jte", Collections.singletonMap("page", users));
        });
        app.get("/users/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            var user = usersList.get(id);
            var page = new UserPage(user);
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        });

        //courses
        app.get("/courses", ctx -> {
            var header = "Courses we have:";
            var courses = new CoursesPage(coursesList, header);
            ctx.render("courses/index.jte", Collections.singletonMap("page",courses));
        });
        app.get("/courses/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            var course = coursesList.get(id);
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });
        return app;
    }
}
