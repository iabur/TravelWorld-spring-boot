package com.iabur.bs23.travel.service;

import com.iabur.bs23.travel.dto.PostDto;
import com.iabur.bs23.travel.model.Post;
import com.iabur.bs23.travel.model.User;
import com.iabur.bs23.travel.repositories.PostRepository;
import com.iabur.bs23.travel.repositories.UserRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void save(PostDto postDto, Authentication authentication){
        Post post = new Post();
        LocalDateTime now = LocalDateTime.now();
        post.setPostBody(postDto.getPostBody());
        post.setPostLocation(postDto.getPostLocation());
        post.setPostTime(now);
        post.setIsPrivate(postDto.getIsPrivate());
        post.setUser(userRepository.findByEmail(authentication.getName()).get());
        postRepository.save(post);
    }

    public List<PostDto> allPublicPost(){
        List<Post> posts = postRepository.findPostByIsPrivate("false");
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach(post -> {
            PostDto postDto = new PostDto();
            postDto.setPostBody(post.getPostBody());
            postDto.setPostLocation(post.getPostLocation());
            postDto.setPostBy(post.getUser().getName());
            PrettyTime p = new PrettyTime();
            String postedAt = p.format(new Date(Timestamp.valueOf(post.getPostTime()).getTime()));
            postDto.setPostTime(postedAt);
            postDtos.add(postDto);
        });
        return postDtos;
    }
}
