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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User(1L, "ruzel", "123");
        Chatroom room = new Chatroom(1L, "dota");
        Message message = new Message(1L, user, room, "New msg!", LocalDate.now().atStartOfDay());
        JdbcDataSource dataSource = new JdbcDataSource();
        MessageRepositoryJdbcImpl repositoryJdbc = new MessageRepositoryJdbcImpl(dataSource.getDataSource());
        repositoryJdbc.save(message);
        System.out.println(message);
    }
}