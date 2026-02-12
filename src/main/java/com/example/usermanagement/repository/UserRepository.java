package com.example.usermanagement.repository;
import com.example.usermanagement.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(User user);
    void update(User user);
}
