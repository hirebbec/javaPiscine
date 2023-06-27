package edu.school21.app;

import edu.school21.models.User;
import edu.school21.repositories.JdbcDataSource;
import edu.school21.repositories.MessageRepositoryJdbcImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JdbcDataSource dataSource = new JdbcDataSource();
        MessageRepositoryJdbcImpl repositoryJdbc = new MessageRepositoryJdbcImpl(dataSource.getDataSource());
        int id;
        System.out.println("Введите id пользователя: ");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        System.out.println(repositoryJdbc.findById(Integer.toUnsignedLong(id)));
    }
}