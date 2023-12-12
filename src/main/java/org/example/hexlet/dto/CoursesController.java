package org.example.hexlet.dto;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoursesController {
    public static void index(Context ctx) {
        var header = "Courses we have: ";
        var term = ctx.queryParam("term");
        var coursesList = CourseRepository.getEntities();
        List<Course> courses;
        if (term != null) {
            courses = coursesList.stream().filter(c -> c.getTitle().contains(term)).collect(Collectors.toList());
            if (courses.isEmpty()) {
                courses = coursesList.stream().filter(c -> c.getDescription().contains(term)).collect(Collectors.toList());
            }
        } else {
            courses = coursesList;
        }
        var page = new CoursesPage(courses, header, term);
        ctx.render("courses/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id).orElseThrow(() -> new NotFoundResponse("Course with id " + id + "not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        try {
//            var title = ctx.formParam("title")
            var title = ctx.formParamAsClass("title", String.class)
                    .check(t -> t.length() > 2, "Title must be longer than 2 symbols")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(d -> d.length() > 10, "Description must be longer than 10 symbols")
                    .get();
            var course = new Course(title, description);
            CourseRepository.save(course);
            ctx.redirect(NamedRoutes.CoursesPath());
        } catch (ValidationException e) {
            var title = ctx.formParam("title");
            var description = ctx.formParam("description");
            var page = new BuildCoursePage(title, description, e.getErrors());
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        }
    }
}
