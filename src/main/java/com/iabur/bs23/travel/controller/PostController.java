package com.iabur.bs23.travel.controller;

import com.iabur.bs23.travel.dto.PostDto;
import com.iabur.bs23.travel.repositories.LocationRepository;
import com.iabur.bs23.travel.service.PostService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    private final PostService postService;
    private final LocationRepository locationRepository;

    public PostController(PostService postService, LocationRepository locationRepository) {
        this.postService = postService;
        this.locationRepository = locationRepository;
    }

    @PostMapping("/savePost")
    public String createPost(@ModelAttribute(name = "post") PostDto postDto, Authentication authentication) {
        postService.save(postDto, authentication);
        return "redirect:/";
    }

    @GetMapping("/editPost")
    public String editPost(@RequestParam(name = "postId") Long postId, Model model) {
        model.addAttribute("postId", postId);
        model.addAttribute("location", locationRepository.findAll());
        model.addAttribute("post",new PostDto());
        return "editPost";
    }

    @PostMapping("/editPost")
    public String editPost(@ModelAttribute(name = "post") PostDto postDto, Authentication authentication) {
        postService.editPost(postDto);
        return "redirect:/profile";
    }
}
