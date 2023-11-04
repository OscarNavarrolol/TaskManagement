
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class ConnectionDB {
    public ConnectionDB() {
    }

    public static Connection getConnectionBD() {
        Connection connection = null;
        String db = "task_management";
        String url = "jdbc:mysql://localhost:3306/" + db;
        String user = "root";
        String password = "";

        try {
            // Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Si sirve");
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e, "Error en la conexión a la base de datos: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            connection = null;
        }

        return connection;
    }
}
