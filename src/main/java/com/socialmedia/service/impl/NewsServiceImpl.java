package com.socialmedia.service.impl;

import com.socialmedia.model.NewsResponse;
import com.socialmedia.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsServiceImpl implements NewsService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public NewsResponse getNews() {

        ResponseEntity<NewsResponse> news;
        NewsResponse newsResponse;
        news = restTemplate.getForEntity("http://localhost:8070/news-service/news", NewsResponse.class);

        if (news.getStatusCode() == HttpStatus.OK) {
            newsResponse = news.getBody();
            if (null != newsResponse && newsResponse.getNewsList() != null) {
                newsResponse.setStatusCode("SUCCESS");
            } else {
                newsResponse = new NewsResponse();
                newsResponse.setStatusCode("FAILED");
                newsResponse.setErrorMessage("Unable to fetch news.");

            }
        } else {
            newsResponse = new NewsResponse();
            newsResponse.setStatusCode("FAILED");
            newsResponse.setErrorMessage("Something went wrong.");
        }
        return newsResponse;
    }
}
