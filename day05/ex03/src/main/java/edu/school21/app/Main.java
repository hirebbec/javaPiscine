package edu.school21.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.models.Chatroom;
import edu.school21.models.Message;
import edu.school21.models.User;
import edu.school21.repositories.JdbcDataSource;
import edu.school21.repositories.MessageRepository;
import edu.school21.repositories.MessageRepositoryJdbcImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JdbcDataSource dataSource = new JdbcDataSource();
        MessageRepository messagesRepository = new MessageRepositoryJdbcImpl(dataSource.getDataSource());
        Optional<Message> optionalMessage = messagesRepository.findById(5L);
            Message message = optionalMessage.get();
            message.setText("Bye");
            message.setDateTime(null);
            messagesRepository.update(message);
    }
}