package com.socialmedia.service.impl;

import com.socialmedia.model.Post;
import com.socialmedia.repository.PostRepository;
import com.socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post addNewPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> postList= postRepository.findAll();
        return postList ;
    }

    @Override
    public void deletePost(int postid) {
        postRepository.deleteById(postid);

    }

    @Override
    public Post getPostById(int postid) {
        return postRepository.findById(postid).get();
    }

    @Override
    public Post updatePost(Post post) {

        Post p=postRepository.findById(post.getId()).get();

        p.setContent(post.getContent());
        p.setDop(new Date());
        p.setUser(post.getUser());

        postRepository.save(p);
        return p;
    }


}
