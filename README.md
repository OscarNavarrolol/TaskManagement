# Task Management Application

This project is a Java task management application that uses a MySQL database to store and manage tasks. The application allows users to create, read, update, and delete tasks, as well as view a list of existing tasks.

## Project structure

The project consists of several Java classes:


- `Principal.java`: This class is the main user interface of the application and contains the logic to interact with the user, create new tasks, and display the list of existing tasks.

- `DateTask.java`: This class handles the task logic, including the insertion, retrieval, update, and deletion of tasks in the database.

- `ConnectionDB.java`:This class is responsible for establishing the connection to the MySQL database.

## Cómo usar la aplicación

1. Ejecuta la aplicación desde `Principal.java`.
2. La aplicación te permite crear nuevas tareas, modificar tareas existentes y eliminar tareas.
3. Las tareas se almacenan en una base de datos MySQL.
4. Puedes ver la lista de tareas existentes en la tabla de la interfaz de usuario.

## Configuración

Asegúrate de configurar la conexión a la base de datos MySQL en la clase `ConnectionDB.java`. Reemplaza los valores de `db`, `url`, `user`, y `password` con tus propias credenciales de la base de datos.

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

## Requisitos
- Java Development Kit (JDK) instalado.
- MySQL Server instalado y en ejecución.


## Capturas de programa

![Captura de pantalla de la cara de la aplicación](https://imgur.com/gallery/5dtkSA7)
![Captura de pantalla de inserción de tarea](https://imgur.com/gallery/RSEBD53)
![Captura de pantalla de actualización de tarea](https://imgur.com/gallery/KT4KRQb)
![Captura de pantalla de eliminación de tarea](https://imgur.com/gallery/4b1HdyS)

