package com.iabur.bs23.travel.controller;

import com.iabur.bs23.travel.dto.PostDto;
import com.iabur.bs23.travel.service.PostService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
   private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/savePost")
    public String createPost(@ModelAttribute(name = "post") PostDto postDto, Model model, Authentication authentication) {
        postService.save(postDto, authentication);
        return "redirect:/";
    }

    /*@PostMapping("/editPost")
    public String editPost(@RequestParam(name = "postId") Long postId) {
        postService.editPost(postId);
        return "redirect:/";
    }*/
}
