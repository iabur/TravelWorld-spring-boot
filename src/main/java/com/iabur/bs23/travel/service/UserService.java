package com.iabur.bs23.travel.service;

import com.iabur.bs23.travel.dto.PostDto;
import com.iabur.bs23.travel.dto.UserDto;
import com.iabur.bs23.travel.exceptions.ResourceAlreadyExistsException;
import com.iabur.bs23.travel.model.Post;
import com.iabur.bs23.travel.repositories.PostRepository;
import com.iabur.bs23.travel.repositories.UserRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.postRepository = postRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException("No user found with this userName"));
        return new User(userFromDb.getEmail(), userFromDb.getPassword(), new ArrayList<>());
    }

    public void create(UserDto userDto){
        com.iabur.bs23.travel.model.User user = new com.iabur.bs23.travel.model.User();
        user.setName(userDto.getFirstName()+" "+userDto.getLastName());
        if(userRepository.findByEmail(userDto.getEmail()).isEmpty()){
            user.setEmail(userDto.getEmail());
        }
        else {
            throw new ResourceAlreadyExistsException("This email already exist! Please try with a different email");
        }
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public com.iabur.bs23.travel.model.User findCurrentUser(Authentication authentication){
        com.iabur.bs23.travel.model.User user = userRepository.findByEmail(authentication.getName()).get();
        return user;
    }

    public List<PostDto> allPost(Authentication authentication){
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> posts = postRepository.findAllByUser(findCurrentUser(authentication));
        posts.forEach(post -> {
            PostDto postDto = new PostDto();
            postDto.setPostBody(post.getPostBody());
            postDto.setPostLocation(post.getPostLocation());
            postDto.setPostBy(post.getUser().getName());
            postDto.setPostId(post.getPostId());
            PrettyTime p = new PrettyTime();
            String postedAt = p.format(new Date(Timestamp.valueOf(post.getPostTime()).getTime()));
            postDto.setPostTime(postedAt);
            postDtos.add(postDto);
        });
        return postDtos;
    }

    public List<PostDto> findPinedPost(Authentication authentication){
        List<Post> post = postRepository.findAllByIsPinedAndUser("true", userRepository.findByEmail(authentication.getName()).get());
        List<PostDto> pDtos = new ArrayList<>();
        post.forEach(p -> {
            PostDto postDto = new PostDto();
            postDto.setPostBody(p.getPostBody());
            postDto.setPostLocation(p.getPostLocation());
            postDto.setPostBy(p.getUser().getName());
            PrettyTime pt = new PrettyTime();
            String postedAt = pt.format(new Date(Timestamp.valueOf(p.getPostTime()).getTime()));
            postDto.setPostTime(postedAt);
            pDtos.add(postDto);
        });
        return pDtos;
    }
}