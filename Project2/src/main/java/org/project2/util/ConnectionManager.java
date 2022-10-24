package org.project2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection con;
    private static Properties properties;

    private ConnectionManager() {

    }

    public static Connection getConnection() throws SQLException {

        if (properties == null) {
            properties = loadProperties();
        }
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        }
        return con;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/jdbc.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return properties;
    }
}
