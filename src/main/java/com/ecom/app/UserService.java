package com.ecom.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> fetchAllUsers(){
         return userList;
    }
    public void addUser(User user){
        user.setId(nextId++);
        userList.add(user);
    }
}
