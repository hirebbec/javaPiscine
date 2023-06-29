package edu.school21.service;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.exceptions.EntityNotFoundException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;

public class UsersServiceImlp {
    UsersRepository usersRepository;

    public boolean authenticate(String login, String password) {
        User user = usersRepository.findByLogin(login);
        if (user == null)
            throw new EntityNotFoundException();
        if (user.isAuthentication())
            throw new AlreadyAuthenticatedException();
        boolean checkPass = user.getPassword().equals(password);
        if (checkPass) {
            user.setAuthentication(true);
            usersRepository.update(user);
        }
        return checkPass;
    }

    public UsersServiceImlp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
