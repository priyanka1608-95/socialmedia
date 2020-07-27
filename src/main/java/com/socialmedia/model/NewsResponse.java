package com.socialmedia.model;

import lombok.Data;

import java.util.List;

@Data
public class NewsResponse {

    private List<News> newsList;
    private String statusCode;
    private String errorMessage;
}
