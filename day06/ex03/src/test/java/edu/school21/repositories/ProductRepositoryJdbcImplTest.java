package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryJdbcImplTest {
    ProductRepositoryJdbcImpl repositoryJdbc;
    DataSource dataSource;

    final List<Product> FIND_ALL = Arrays.asList(
            new Product(1l, "Pure", 420, 10),
            new Product(2l, "Love", 210, 10),
            new Product(3l, "Tea", 105, 10),
            new Product(4l, "Coffee", 1000, 10),
            new Product(5l, "Milk", 600, 10),
            new Product(6l, "Smile", 450, 10));

    final Product FIND_BY_ID = new Product(4l, "Coffee", 1000, 10);
    final Product UPDATED_PRODUCT = new Product(5l, "Lemon", 99, 10);
    final Product SAVE_PRODUCT = new Product(7l, "Fish", 690, 10);

    final List<Product> PRODUCTS_AFTER_DELETE = Arrays.asList(
            new Product(1l, "Pure", 420, 10),
            new Product(2l, "Love", 210, 10),
            new Product(4l, "Coffee", 1000, 10),
            new Product(5l, "Milk", 600, 10),
            new Product(6l, "Smile", 450, 10));

    @BeforeEach
    public void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        repositoryJdbc = new ProductRepositoryJdbcImpl(dataSource);
    }

    @Test
    public void findAllTest() {
        assertEquals(repositoryJdbc.findAll(), FIND_ALL);
    }

    @Test
    public void findByIDTest() {
        assertEquals(repositoryJdbc.findById(4L).get(), FIND_BY_ID);
    }

    @Test
    public void updateTest() {
        repositoryJdbc.update(new Product(5L, "Lemon", 99, 10));
        assertEquals(repositoryJdbc.findById(5L).get(), UPDATED_PRODUCT);
    }

    @Test
    public void saveTest() {
        repositoryJdbc.save(new Product(7L, "Fish", 690, 10));
        assertEquals(repositoryJdbc.findById(7L).get(), SAVE_PRODUCT);
    }

    @Test
    public void deleteTest() {
        repositoryJdbc.delete(3L);
        assertEquals(repositoryJdbc.findAll(), PRODUCTS_AFTER_DELETE);
    }
}
