package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> config.plugins.enableDevLogging());
        app.get("/", ctx -> ctx.result("Hello, world!"));
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/hello", ctx -> {
           var name = ctx.queryParam("name");
           String hello = "";
           if (name != null) {
               hello = "Hello, " + name + "!";
           } else {
               hello = "Hello, World!";
           }
           ctx.result(hello);
        });
        app.start(7070);
    }
}
