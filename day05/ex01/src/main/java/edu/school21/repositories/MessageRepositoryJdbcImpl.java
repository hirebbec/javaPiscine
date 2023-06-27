package edu.school21.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.models.Chatroom;
import edu.school21.models.Message;
import edu.school21.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class MessageRepositoryJdbcImpl implements MessageRepository {

    HikariDataSource dataSource;
    @Override
    public Optional<Message> findById(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Message WHERE id=" + id);
            if (!resultSet.next()) {
                return Optional.empty();
            }
            return Optional.of(new Message(resultSet.getLong(1), getUserById(resultSet.getLong(2)), getRoomById(resultSet.getLong(3)), resultSet.getString(4), resultSet.getDate(5)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUserById(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"User\" WHERE id=" + id);
            if (!resultSet.next())
                return null;
            return new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Chatroom getRoomById(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Chatroom WHERE id=" + id);
            if (!resultSet.next())
                return null;
            return new Chatroom(resultSet.getLong(1), resultSet.getString(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MessageRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
