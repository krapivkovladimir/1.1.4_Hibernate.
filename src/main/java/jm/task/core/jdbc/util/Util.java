package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_schema";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private Connection db_connector;

    public Connection getConnection() {
        try {
            db_connector = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе данных", e);
        }
        return db_connector;
    }
}
