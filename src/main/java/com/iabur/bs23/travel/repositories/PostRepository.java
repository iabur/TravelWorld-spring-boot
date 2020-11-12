package com.iabur.bs23.travel.repositories;

import com.iabur.bs23.travel.model.Post;
import com.iabur.bs23.travel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostByIsPrivate(String p);
    List<Post> findAllByUser(User user);
}