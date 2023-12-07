package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.parseInt(port);
    }
    public static void main(String[] args) {
        var app = getApp();
        app.start(getPort());
    }
    public static Javalin getApp() {
        var usersList = UserRepository.getEnteties();
        var coursesList = CourseRepository.getEntities();
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

        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });
        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/users/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var user = UserRepository.find(id).get();
            var page = new UserPage(user);
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        });



        //courses
        app.get("/courses", ctx -> {
            var header = "Courses we have:";
            var term = ctx.queryParam("term");
            List<Course> courses;
            if (term != null) {
                courses = coursesList.stream().filter(c -> c.getName().contains(term)).collect(Collectors.toList());
                if (courses.size() == 0) {
                    courses = coursesList.stream().filter(c -> c.getDescription().contains(term)).collect(Collectors.toList());
                }
            } else {
                courses = coursesList;
            }
            var page = new CoursesPage(courses, header, term);
            ctx.render("courses/index.jte", Collections.singletonMap("page",page));
        });

        app.get("/courses/build", ctx -> {
           ctx.render("courses/build.jte");
        });

        app.post("/courses", ctx -> {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();
            var course = new Course(name, description);
            CourseRepository.save(course);

            ctx.redirect("/courses");
        });
        app.get("/courses/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var course = CourseRepository.find(id).get();
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });
        return app;
    }
}
