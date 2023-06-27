package edu.school21.repositories;

import edu.school21.models.Message;

import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findById(Long id);
    void save(Message message);
}
