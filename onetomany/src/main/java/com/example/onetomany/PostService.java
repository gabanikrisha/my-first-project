package com.example.onetomany;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService
{
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost(Long userId, Post post) {
        User user = userRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        post.setUser(user);
        return postRepository.save(post);
    }

    public List<Post>getPostsByUser(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
