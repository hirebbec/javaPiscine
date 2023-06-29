package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryJdbcImpl implements ProductRepository {

    private  DataSource dataSource;

    public ProductRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products;");
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE id=" + id);
            if (!resultSet.next())
                return Optional.empty();
            return Optional.of(new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE products SET name=\'" + product.getName() + "\', price=" + product.getPrice() + ", count=" + product.getCount() + "WHERE id=" + product.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Product product) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("INSERT INTO products (name, price, count) VALUES\n" +
                    "(\'" + product.getName() + "\', " + product.getPrice() + ", " + product.getCount() + ")");
            if (!resultSet.next())
                return;
            product.setId(resultSet.getLong(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("DELETE FROM products WHERE id=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
