package org.example.hexlet.dto;

public class NamedRoutes {
    public static String UsersPath() {
        return "/u";
    }
    public static String BuildUserPath() {
        return "/u/build";
    }

    public static String UserPath(Long id) {
        return UserPath(String.valueOf(id));
    }

    public static String UserPath(String id) {
        return "/u/" + id;
    }

    public static String CoursesPath() {
        return "/courses";
    }

    public static String BuildCoursePath() {
        return "/courses/build";
    }
    public static String CoursePath(Long id) {
        return CoursePath(String.valueOf(id));
    }
    public static String CoursePath(String id) {
        return "/courses/" + id;
    }
}
