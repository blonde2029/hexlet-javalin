package org.example.hexlet.dto;

public class NamedRoutes {
    public static String UsersPath() {
        return "/users";
    }
    public static String BuildUserPath() {
        return "/users/build";
    }

    public static String UserPath(Long id) {
        return UserPath(String.valueOf(id));
    }

    public static String UserPath(String id) {
        return "/users/" + id;
    }

    public static String EditUserPath(Long id) {
        return EditUserPath(String.valueOf(id));
    }
    public static String EditUserPath(String id) {
        return "/users/" + id + "/edit";
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

    public static String EditCoursePath(Long id) {
        return CoursePath(String.valueOf(id)) + "/edit";
    }
}
