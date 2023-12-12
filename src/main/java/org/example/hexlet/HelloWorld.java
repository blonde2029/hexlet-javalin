package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.dto.CoursesController;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.UsersController;

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
            ctx.render("layout/page.jte");
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
        return app;
    }
}
