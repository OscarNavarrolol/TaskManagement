CREATE DATABASE task_management;

USE task_management;

-- Crear la tabla para almacenar las tareas
CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(30) NOT NULL,
    task_description varchar(255),
    task_due_date varchar(12),
    task_priority INT,
    task_status VARCHAR(5)
);

insert into tasks (task_name,task_description,task_due_date,task_priority,task_status)
values("Compra navidad","Comprar el arbol y lo juguetes para los niños","12/12/2002",1,"NOT");

SELECT * FROM tasks;

alter table tasks 
modify task_description varchar(500);