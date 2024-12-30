import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseExample {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database.");

            // Example: Fetching users
            String query = "SELECT * FROM users";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int userId = resultSet.getInt("user_id");
                    String username = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    System.out.println("User  ID: " + userId + ", Username: " + username + ", Email: " + email);
                }
            }

            // Example: Inserting a new user
            String insertQuery = "INSERT INTO users (username, email) VALUES (?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, "dave");
                insertStatement.setString(2, "dave@example.com");
                int rowsAffected = insertStatement.executeUpdate();
                System.out.println("Inserted " + rowsAffected + " row(s).");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
