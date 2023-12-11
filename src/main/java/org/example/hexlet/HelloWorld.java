package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
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
            var page = new BuildUserPage();
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        });
        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(p -> p == passwordConfirmation, "Password not confirmed")
                        .get();
                var user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", Collections.singletonMap("page", page));
            }

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
            var page = new BuildCoursePage();
           ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/courses", ctx -> {
            var nameDefault = ctx.formParamAsClass("name", String.class).get().trim();
            var descriptionDefault = ctx.formParam("description");
            try {
              var name = ctx.formParamAsClass("name", String.class)
                      .check(n -> n.length() > 2, "Name must be longer than 2 symbols")
                      .get().trim();
              var description = ctx.formParamAsClass("description", String.class)
                        .check(d -> d.length() > 10, "Description must be longer than 10 symbols")
                        .get().trim();
              var course = new Course(name, description);
              CourseRepository.save(course);
              ctx.redirect("/courses");
            } catch (ValidationException e) {
              var page = new BuildCoursePage(nameDefault, descriptionDefault, e.getErrors());
              ctx.render("courses/build.jte", Collections.singletonMap("page", page));
            }
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
