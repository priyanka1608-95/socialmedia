package com.socialmedia.service.impl;

import com.socialmedia.model.Post;
import com.socialmedia.model.PostRequest;
import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public User login(User u) {
        return userRepository.findByEmailAndPassword(u.getEmail(),u.getPassword());
    }

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList= (List<User>) userRepository.findAll();
        return userList ;
    }

    @Override
    public User getUserById(int userid) {
        return userRepository.findById(userid).get();
    }

    @Override
    public User addOrUpdatePost(PostRequest post)
    {

        log.debug(post.toString());

        User u=userRepository.findById(post.getUserId()).get();
        List<Post> postList = u.getPosts();

        if(post.getRequestType().equalsIgnoreCase("create")) {

            Post newPost=new Post();
            newPost.setUser(u);
            newPost.setContent(post.getPost().getContent());
            newPost.setDop(new Date());
            postList.add(newPost);
            u.setPosts(postList);
        } else {

            Post updatePost = post.getPost();
            updatePost.setDop(new Date());
            updatePost.setUser(u);
            postList.add(updatePost);
            u.setPosts(postList);
        }

        return userRepository.save(u);
    }


}
