
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Oscar
 */
public class ConnectionDB {
    public ConnectionDB() {
    }
    // Method to establish a database connection
    public static Connection getConnectionBD() {
        Connection connection = null;
        String db = "task_management";
        String url = "jdbc:mysql://localhost:3306/" + db;
        String user = "root";
        String password = "";

        try {
            // Load the MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Connection established successfully.");
            
        } catch (SQLException | ClassNotFoundException e) {
            // Handle exceptions related to connection errors
            JOptionPane.showMessageDialog(null, e, "Error in the database connection: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            connection = null; // Set connection to null on error
        }

        return connection; // Return the established database connection (or null on error)
    }
}
