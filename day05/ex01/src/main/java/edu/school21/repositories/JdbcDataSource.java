package edu.school21.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDataSource {

    private HikariConfig config;
    HikariDataSource dataSource;
    public HikariDataSource getDataSource() {
        return  dataSource;
    }

    public JdbcDataSource() {
        Properties properties = new Properties();

        try  {
            properties.load(HikariDataSource.class.getResourceAsStream("/configuration.properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        config = new HikariConfig();
        config.setJdbcUrl(properties.getProperty("jdbc.url"));
        config.setPassword(properties.getProperty("jdbc.password"));
        config.setUsername(properties.getProperty("jdbc.username"));
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
