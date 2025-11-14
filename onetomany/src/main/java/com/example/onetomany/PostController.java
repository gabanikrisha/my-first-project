package com.example.onetomany;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    // 👉 Create User
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 👉 Create Post for specific User
    @PostMapping("/users/{userId}/posts")
    public Post createPost(@PathVariable Long userId, @RequestBody Post post) {
        User user = userRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        post.setUser(user);
        return postRepository.save(post);
    }

    // 👉 Get all posts by User
    @GetMapping("/users/{userId}/posts")
    public List<Post> getPostsByUser(@PathVariable Long userId) {
        return postRepository.findByUserId(userId);
    }
}
