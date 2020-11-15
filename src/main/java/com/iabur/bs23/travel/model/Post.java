package com.iabur.bs23.travel.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long postId;

    @Column(name = "postBody")
    private String postBody;

    @Column(name = "postTime")
    private LocalDateTime postTime;

    @Column(name = "postLocation")
    private String postLocation;

    @Column(name = "isPrivate")
    private String isPrivate;

    @Column(name = "isPined")
    private String isPined;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Post() {
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

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
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

    public String getIsPined() {
        return isPined;
    }

    public void setIsPined(String isPined) {
        this.isPined = isPined;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
