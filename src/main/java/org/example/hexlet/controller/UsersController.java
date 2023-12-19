package org.example.hexlet.controller;


import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.util.Collections;

public class UsersController {
    public static void index(Context ctx) {
        var users = UserRepository.getEnteties();
        var page = new UsersPage(users);
        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("Entity wit id " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(p -> p.equals(passwordConfirmation), "Password not confirmed")
                    .get();
            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect(NamedRoutes.UsersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.formParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("User with id " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/edit", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.formParamAsClass("id", Long.class).get();
        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("User with id " + id + "not found"));
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.UsersPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.formParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.UsersPath());
    }
}
