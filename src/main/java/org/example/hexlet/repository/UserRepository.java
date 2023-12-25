package org.example.hexlet.repository;

import org.example.hexlet.model.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository {
    private static List<User> enteties = new ArrayList<User>();
    public static void save(User user) throws SQLException {
        var sql = "INSERT INTO users (name, email, password) VALUES(?, ?, ?)";
        try (var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            var generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned id after saving an entity");
            }
        }
        user.setId((long)enteties.size() + 1);
        enteties.add(user);
    }

//    public static List<User> search(String term) {
//        var users = enteties.stream().filter(u -> u.getName().startsWith(term))
//                .collect(Collectors.toList());
//        return users;
//    }

    public static Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement(sql)) {
        stmt.setLong(1, id);
        var resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            var name = resultSet.getString("name");
            var email = resultSet.getString("email");
            var password = resultSet.getString("password");
            var user = new User(name, email, password);
            user.setId(id);
            return Optional.of(user);
        }
        return Optional.empty();
        }
    }

//    public static void delete(Long id) throws SQLException {
//        var user = find(id).orElseThrow(() -> new NotFoundResponse("User with " + id + " not found"));
//        enteties.remove(user);
//    }
    public static List<User> getEnteties() throws SQLException {
        var sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(name, email, password);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }
}
