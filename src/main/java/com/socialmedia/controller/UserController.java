package com.socialmedia.controller;

import com.socialmedia.model.Post;
import com.socialmedia.model.PostRequest;
import com.socialmedia.model.User;
import com.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        User u=userService.addUser(user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user)
    {
        User u=userService.login(user);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> userList=new ArrayList<>();
        userList=userService.getAllUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userid}")
    public ResponseEntity<?> getUserById(@PathVariable int userid)
    {
        User u=userService.getUserById(userid);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @PostMapping("/addOrUpdatePost")
    public ResponseEntity<?> addOrUpdatePost(@RequestBody PostRequest post)
    {
        User u=userService.addOrUpdatePost(post);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

}
