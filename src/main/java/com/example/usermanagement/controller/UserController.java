package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long Id){
        return userService.findById(Id);
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user,
                           @PathVariable Long id){
        user.setId(id);
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
}
