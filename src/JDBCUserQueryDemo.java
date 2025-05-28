import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBCUserQueryDemo {
    public static void main(String[] args) {
        // JDBC connection details
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "Manikumar@8";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ JDBC driver loaded.");


            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL database.");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");


            System.out.println("\n🧾 Users Table:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }


            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\n🔒 Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ SQL Error: " + e.getMessage());
        }
    }
}
