package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.BasePage;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.repository.BaseRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Collections;
import java.util.stream.Collectors;

public class HelloWorld {
    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.parseInt(port);
    }
    public static void main(String[] args) throws SQLException, IOException {
        var app = getApp();
        app.start(getPort());
    }
    private static String readResourceFile(String fileName) throws IOException {
        var inputStream = HelloWorld.class.getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
    public static Javalin getApp() throws IOException, SQLException {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");
        var dataSource = new HikariDataSource(hikariConfig);
//        var url = HelloWorld.class.getClassLoader().getResource("schema.sql");
//        var file = new File(url.getFile());
//        var sql = Files.lines(file.toPath()).collect(Collectors.joining());
        var sql = readResourceFile("schema.sql");
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
          statement.execute(sql);
        }

        BaseRepository.dataSource = dataSource;
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/", ctx -> {
//            var visited = Boolean.valueOf(ctx.cookie("visited"));
//            var page = new MainPage(visited);
//            ctx.render("layout/page.jte", Collections.singletonMap("page", page));
//            ctx.cookie("visited", String.valueOf(true));
//            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            var page = new BasePage();
            ctx.render("layout/page.jte", Collections.singletonMap("page", page));
        });

        //users
        app.get(NamedRoutes.UsersPath(), UsersController::index);

        app.get(NamedRoutes.BuildUserPath(), UsersController::build);
        app.post(NamedRoutes.UsersPath(), UsersController::create);
        app.get(NamedRoutes.EditUserPath("{id}"), UsersController::edit);
        app.patch(NamedRoutes.UserPath("{id}"), UsersController::update);
//        app.delete(NamedRoutes.UserPath("{id}"), UsersController::destroy);
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
