import java.sql.*;

public class UserDatabaseManager {
    static final String URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASS = "Manikumar@8";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("✅ Connected to database.");

            insertUser(conn, "Alice", "alice@example.com");
            insertUser(conn, "Bob", "bob@example.com");

            listUsers(conn);

            updateEmail(conn, 1, "alice.new@email.com");

            deleteUser(conn, 2);

            listUsers(conn);

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
    }

    public static void insertUser(Connection conn, String name, String email) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("✅ Inserted user: " + name);
        }
    }

    public static void listUsers(Connection conn) throws SQLException {
        String sql = "SELECT * FROM users";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n📋 All Users:");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Email: %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
        }
    }

    public static void updateEmail(Connection conn, int userId, String newEmail) throws SQLException {
        String sql = "UPDATE users SET email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, userId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("🔄 Updated email for user ID: " + userId);
            } else {
                System.out.println("⚠️ No user found with ID: " + userId);
            }
        }
    }

    public static void deleteUser(Connection conn, int userId) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("🗑️ Deleted user with ID: " + userId);
            } else {
                System.out.println("⚠️ No user found with ID: " + userId);
            }
        }
    }
}

