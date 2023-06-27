package edu.school21.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmbeddedDataSourceTest {

    DataSource dataSource;
    @BeforeEach
    void init() {
       dataSource = new EmbeddedDatabaseBuilder()
               .setType(EmbeddedDatabaseType.HSQL)
               .addScript("schema.sql")
               .addScript("data.sql")
               .build();
    }

    @Test
    public void getConnection() {
        try {
            assertNotNull(dataSource.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
