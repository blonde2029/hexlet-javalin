package org.example.hexlet.repository;

import io.javalin.http.NotFoundResponse;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository {
    private static List<User> enteties = new ArrayList<User>();
    public static void save(User user) {
        user.setId((long)enteties.size() + 1);
        enteties.add(user);
    }

    public static List<User> search(String term) {
        var users = enteties.stream().filter(u -> u.getName().startsWith(term))
                .collect(Collectors.toList());
        return users;
    }

    public static Optional<User> find(Long id) {
        var user = enteties.stream().filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
        return Optional.of(user);
    }

    public static void delete(Long id) {
        var user = find(id).orElseThrow(() -> new NotFoundResponse("User with " + id + " not found"));
        enteties.remove(user);
    }
    public static List<User> getEnteties() {
        return enteties;
    }
}
