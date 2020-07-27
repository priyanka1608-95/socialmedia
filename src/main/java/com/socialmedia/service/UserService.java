package com.socialmedia.service;

import com.socialmedia.model.PostRequest;
import com.socialmedia.model.User;

import java.util.List;

public interface UserService {

    User login(User u);
    User addUser(User u);

    List<User> getAllUsers();

    User getUserById(int userid);

    User addOrUpdatePost(PostRequest post);
}
