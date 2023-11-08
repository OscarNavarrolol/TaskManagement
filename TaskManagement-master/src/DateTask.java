import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Oscar 
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
    
    // Constructor to initialize the DateTask object with details
    public DateTask(int id, String task_name, String task_description, String task_due_date, int task_priority, String task_status) {
        this.id = id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_due_date = task_due_date;
        this.task_priority = task_priority;
        this.task_status = task_status;
    }
    
    // Getter and Setter methods for private fields
    // Getters return the values, and setters set the values

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
    
    // Method to insert a new task record into a database
    public void insertRecord(String task_name, String task_description, String task_due_date, int task_priority, String task_status) {
    
    // SQL query to insert a new task record    
    String sql = "INSERT INTO tasks (task_name, task_description, task_due_date, task_priority, task_status) VALUES (?, ?, ?, ?, ?)";
    // code to execute SQL query, handle success or failure
    try (Connection connection = ConnectionDB.getConnectionBD();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, task_name);
        preparedStatement.setString(2, task_description);
        preparedStatement.setString(3, task_due_date);
        preparedStatement.setInt(4, task_priority);
        preparedStatement.setString(5, task_status);

        int cantRegistros = preparedStatement.executeUpdate();

        if (cantRegistros > 0) {
            JOptionPane.showMessageDialog(null, "Inserted");
        } else {
            JOptionPane.showMessageDialog(null, "Insertion failed");
        }
    } catch (Exception e) {
        e.printStackTrace();
        // Maneja la excepción según sea necesario.
    }
    }
    
    // Method to retrieve and display task details in a JTable
    public void showDetails(JTable tableTask){
    //code to create a table model, retrieve data from the database, and display it in the JTable  
        ConnectionDB conectar = new ConnectionDB();
        DefaultTableModel modeloBas = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenTabla = new TableRowSorter<TableModel>(modeloBas);
        tableTask.setRowSorter(OrdenTabla);
        
        String sql ="";
        modeloBas.addColumn("ID");
        modeloBas.addColumn("NAME");
        modeloBas.addColumn("DESCRIPTION");
        modeloBas.addColumn("DATE");
        modeloBas.addColumn("PRIOTITY");
        modeloBas.addColumn("COMPLETE");
        
        tableTask.setModel(modeloBas);
       
        tableTask.setDefaultEditor(Object.class, null);
        
        
        sql = "select * from tasks;";
        
        String [] valores = new String[6];
        
        try {
            Connection connect = conectar.getConnectionBD();
            PreparedStatement st = connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
              
                valores[0]=rs.getString(1);
                valores[1]=rs.getString(2);
                valores[2]=rs.getString(3);
                valores[3]=rs.getString(4);
                valores[4]=rs.getString(5);
                valores[5]=rs.getString(6);
                
                modeloBas.addRow(valores);
            }
            tableTask.setModel(modeloBas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error."+e.getMessage());
        }
    }
        
    // Method to retrieve task details by task ID
    public DateTask getTaskDetails(int taskId) {
    // SQL query to select a task by its ID    
    String sql = "SELECT * FROM tasks WHERE id = ?";
    
    //code to execute SQL query, retrieve task details, and return a DateTask object
    try (Connection connection = ConnectionDB.getConnectionBD();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, taskId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            DateTask task = new DateTask();
            task.setId(resultSet.getInt("id"));
            task.setTask_name(resultSet.getString("task_name"));
            task.setTask_description(resultSet.getString("task_description"));
            task.setTask_due_date(resultSet.getString("task_due_date"));
            task.setTask_priority(resultSet.getInt("task_priority"));
            task.setTask_status(resultSet.getString("task_status"));
            return task;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    // Method to update task details by task ID
    public void updateTask(int taskId, String newTaskName, String newTaskDescription, String newDueDate, int newTaskPriority, String newTaskStatus) {
    // SQL query to update task details    
    String sql = "UPDATE tasks SET task_name = ?, task_description = ?, task_due_date = ?, task_priority = ?, task_status = ? WHERE id = ?";
    //code to execute SQL query, handle success or failure
    try (Connection connection = ConnectionDB.getConnectionBD();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, newTaskName);
        preparedStatement.setString(2, newTaskDescription);
        preparedStatement.setString(3, newDueDate);
        preparedStatement.setInt(4, newTaskPriority);
        preparedStatement.setString(5, newTaskStatus);
        preparedStatement.setInt(6, taskId);

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Update successful. " + rowsAffected + " row updates.");
        } else {
            JOptionPane.showMessageDialog(null, "Task update failed. Please verify the task code.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating the task. Error:  " + e.getMessage());
    }
}
    // Method to delete a task by its ID
    public void deleteTask(int taskId) {
    // SQL query to delete a task by its ID    
    String sql = "DELETE FROM tasks WHERE id = ?";
    
    // code to execute SQL query, handle success or failure
    try (Connection connection = ConnectionDB.getConnectionBD();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, taskId);

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Task deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Unable to delete the task. Please verify the task code.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting the task. Error:  " + e.getMessage());
    }
    }
    
    }




        
    
    
    
    

    
