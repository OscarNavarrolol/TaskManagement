
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class DateTask {
    private int id ;
    private String task_name ;
    private String task_description; 
    private String task_due_date ;
    private int task_priority ;     
    private String task_status ;

    public DateTask() {
    }

    public DateTask(int id, String task_name, String task_description, String task_due_date, int task_priority, String task_status) {
        this.id = id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_due_date = task_due_date;
        this.task_priority = task_priority;
        this.task_status = task_status;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_due_date() {
        return task_due_date;
    }

    public void setTask_due_date(String task_due_date) {
        this.task_due_date = task_due_date;
    }

    public int getTask_priority() {
        return task_priority;
    }

    public void setTask_priority(int task_priority) {
        this.task_priority = task_priority;
    }
    
   public void insertRecord(String task_name, String task_description, String task_due_date, int task_priority, String task_status) {
    String sql = "INSERT INTO tasks (task_name, task_description, task_due_date, task_priority, task_status) VALUES (?, ?, ?, ?, ?)";

    Connection connection = ConnectionDB.getConnectionBD();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, task_name);
        preparedStatement.setString(2, task_description);
        preparedStatement.setString(3, task_due_date);
        preparedStatement.setInt(4, task_priority);
        preparedStatement.setString(5, task_status);

        int cantRegistres=preparedStatement.executeUpdate();

        if (cantRegistres>0){
            JOptionPane.showMessageDialog(null, "Insertado");
        } else{
             JOptionPane.showMessageDialog(null, "No se pudo");

        }

    } catch (Exception e) {
        e.printStackTrace();
        // Handle the exception as needed.
    } 
}
   

        
    }

    
