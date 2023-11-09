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


[![Screenshot-2.png](https://i.postimg.cc/44vmNs5T/Screenshot-2.png)](https://postimg.cc/MXTW9kNs)
[![Screenshot-1.png](https://i.postimg.cc/hvnvb5Kw/Screenshot-1.png)](https://postimg.cc/MMszztMb)
[![Update.png](https://i.postimg.cc/fyvLHfLb/Update.png)](https://postimg.cc/hQfcvxVF)
[![delete.png](https://i.postimg.cc/RFKqtBxK/delete.png)](https://postimg.cc/cg1sqPHL)


---

Do you have any questions or suggestions? Please do not hesitate to contact me!

[Contact Email](mailto:oscardnv123455@gmail.com) | [Contact Email](https://github.com/OscarNavarrolol)
