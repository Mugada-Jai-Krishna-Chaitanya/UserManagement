package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryUserRepository implements UserRepository{

    @Override
    public List<User> findAll() {
        return List.of(
                new User(1L,"Jai","jai@gmail.com"),
                new User(2L, "krishna","krishna@gmail.com")
        );
    }
}
