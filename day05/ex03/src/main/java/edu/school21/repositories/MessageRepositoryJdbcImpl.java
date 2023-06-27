package edu.school21.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.exceptions.NotSavedSubEntityException;
import edu.school21.models.Chatroom;
import edu.school21.models.Message;
import edu.school21.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
            return Optional.of(new Message(resultSet.getLong(1), getUserById(resultSet.getLong(2)), getRoomById(resultSet.getLong(3)), resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Message message) {
        if (!checkMessage(message))
            throw new NotSavedSubEntityException();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("INSERT INTO Message (author_id, room_id, text) VALUES\n" +
                    "(" + message.getAuthor().getId() + ", " + message.getRoom().getId() + ", \'" + message.getText() + "\') RETURNING id;");
            if (!resultSet.next())
                throw new RuntimeException();
            message.setId(resultSet.getLong(1));
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

    @Override public void update(Message message) {
        if (!checkMessage(message))
        throw new NotSavedSubEntityException();
        try { Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Message SET author_id="
                    + message.getAuthor().getId() + "" + ", room_id="
                    + message.getRoom().getId() + ", text = \'"
                    + message.getText() + "\' " + ", date = "
                    + message.getDate() + " WHERE id=" + message.getId());
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

    private boolean checkMessage(Message message) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"User\" WHERE id=" + message.getAuthor().getId());
            if (!resultSet.next())
                return false;
            resultSet = statement.executeQuery("SELECT * FROM Chatroom WHERE id=" + message.getRoom().getId());
            if (!resultSet.next())
                return false;
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
