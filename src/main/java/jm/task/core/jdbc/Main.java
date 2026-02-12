package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        String[][] users = {
                {"Иван", "Иванов", "25"},
                {"Мария", "Петрова", "30"},
                {"Алексей", "Сидоров", "28"},
                {"Ольга", "Смирнова", "22"}
        };
        for (String[] u : users) {
            String name = u[0];
            String lastName = u[1];
            byte age = Byte.parseByte(u[2]);

            userService.saveUser(name, lastName, age);
            System.out.println("User с именем — " + name + " добавлен в базу данных");
        }
        System.out.println("\nВсе пользователи из базы:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
