package com.ecom.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.fetchAllUsers();
    }
    @GetMapping("/api/users/{id}")
    public List<User> getAllUsers(@PathVariable long id){
        return userService.fetchAllUsers();
    }
    @PostMapping("/api/users")
    public void createUser(@RequestBody User user){
        userService.addUser(user);
    }
}
