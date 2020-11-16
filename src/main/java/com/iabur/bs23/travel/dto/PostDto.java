package com.iabur.bs23.travel.dto;

public class PostDto {
    private Long postId;
    private String postBody;
    private String postLocation;
    private String isPrivate;
    private boolean isPined;
    private String postBy;
    private String postTime;
    private Long userId;

    public PostDto() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isPined() {
        return isPined;
    }

    public void setPined(boolean pined) {
        isPined = pined;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
