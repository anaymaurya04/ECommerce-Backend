package com.ecom.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/api/users")
    public ResponseEntity<Void> createUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User updatedUser, @PathVariable long id){
        boolean updated = userService.updateUser(id, updatedUser);
        if (updated) {
            return ResponseEntity.ok("User updated successfully");

        }
        return ResponseEntity.notFound().build();
    }
}
