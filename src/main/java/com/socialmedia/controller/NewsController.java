package com.socialmedia.controller;

import com.socialmedia.model.News;
import com.socialmedia.model.NewsResponse;
import com.socialmedia.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
public class NewsController
{
    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public ResponseEntity<?> getNews()
    {
        NewsResponse newsResponse =newsService.getNews();

        return new ResponseEntity<>(newsResponse, HttpStatus.OK);
    }
}
