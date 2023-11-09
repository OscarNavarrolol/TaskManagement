# Task Management Application

This project is a Java task management application that uses a MySQL database to store and manage tasks. The application allows users to create, read, update, and delete tasks, as well as view a list of existing tasks.

## Project structure

The project consists of several Java classes:


- `Principal.java`: This class is the main user interface of the application and contains the logic to interact with the user, create new tasks, and display the list of existing tasks.

- `DateTask.java`: This class handles the task logic, including the insertion, retrieval, update, and deletion of tasks in the database.

- `ConnectionDB.java`:This class is responsible for establishing the connection to the MySQL database.

## How to use the application

1. Run the application from `Principal.java`.
2. The application allows you to create new tasks, modify existing tasks, and delete tasks.
3. The tasks are stored in a MySQL database.
4. You can view the list of existing tasks in the user interface table.

## Configuration

Make sure to configure the MySQL database connection in the class. `ConnectionDB.java`. Replace the values of `db`, `url`, `user`, and `password` With your own database credentials.

```java
public static Connection getConnectionBD() {
    Connection connection = null;
    String db = "task_management";
    String url = "jdbc:mysql://localhost:3306/" + db;
    String user = "root";
    String password = "";

    // ...
}
```

## Requirements
- Java Development Kit (JDK) installed.
- MySQL Server installed and running


## Program screenshots

![Screenshot of the application interface](https://imgur.com/gallery/5dtkSA7)
![Screenshot of task insertion.](https://imgur.com/gallery/RSEBD53)
![Screenshot of task update.](https://imgur.com/gallery/KT4KRQb)
![Screenshot of task deletion.](https://imgur.com/gallery/4b1HdyS)

