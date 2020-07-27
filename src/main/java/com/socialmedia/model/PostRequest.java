package com.socialmedia.model;

import lombok.Data;

@Data
public class PostRequest {
    private Post post;
    private int userId;
    private String requestType;
}
