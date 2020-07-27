package com.socialmedia.controller;

import com.socialmedia.model.Post;
import com.socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostController
{
    @Autowired
    PostService postService;


    @GetMapping("/getAllPosts")
    public ResponseEntity<?> getAllPosts()
    {
        List<Post> postList= new ArrayList<>();
        postList=postService.getAllPosts();
        return new ResponseEntity<>(postList,HttpStatus.OK);
    }

    @PostMapping("/newPost")
    public ResponseEntity<?> addNewPost(@RequestBody Post post)
    {
        Post p=postService.addNewPost(post);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/deletePost/{postid}")
    public void deletePost(@PathVariable int postid)
    {
        postService.deletePost(postid);
    }

    @GetMapping("/getPostById/{postid}")
    public ResponseEntity<?> getPostById(@PathVariable int postid)
    {
        Post post=postService.getPostById(postid);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<?> updatePost(@RequestBody Post post)
    {
        Post p=postService.updatePost(post);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }





}
