package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.NamedRoutes;

import java.util.Collections;

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
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/", ctx -> {
//            var visited = Boolean.valueOf(ctx.cookie("visited"));
//            var page = new MainPage(visited);
//            ctx.render("layout/page.jte", Collections.singletonMap("page", page));
//            ctx.cookie("visited", String.valueOf(true));
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("layout/page.jte", Collections.singletonMap("page", page));
        });

        //users
        app.get(NamedRoutes.UsersPath(), UsersController::index);

        app.get(NamedRoutes.BuildUserPath(), UsersController::build);
        app.post(NamedRoutes.UsersPath(), UsersController::create);
        app.get(NamedRoutes.EditUserPath("{id}"), UsersController::edit);
        app.patch(NamedRoutes.UserPath("{id}"), UsersController::update);
        app.delete(NamedRoutes.UserPath("{id}"), UsersController::destroy);
        app.get(NamedRoutes.UserPath("{id}"), UsersController::show);



        //courses
        app.get(NamedRoutes.CoursesPath(), CoursesController::index);
        app.get(NamedRoutes.BuildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.CoursesPath(), CoursesController::create);
        app.get(NamedRoutes.CoursePath("{id}"), CoursesController::show);


// Отображение формы логина
        app.get("/sessions/build", SessionsController::build);
// Процесс логина
        app.post("/sessions", SessionsController::create);
// Процесс выхода из аккаунта
        app.delete("/sessions", SessionsController::destroy);
        return app;
    }
}
