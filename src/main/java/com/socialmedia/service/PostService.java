package com.socialmedia.service;

import com.socialmedia.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService
{
    Post addNewPost(Post post);

    List<Post> getAllPosts();

    void deletePost(int postid);

    Post getPostById(int postid);

    Post updatePost(Post post);
}
