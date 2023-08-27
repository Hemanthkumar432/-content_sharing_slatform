package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Controller;

import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto.PostDto;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto.PostResponseDto;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto.SearchRequestDto;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.Post;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.User;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Repo.UserRepository;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Repo.PostRepository;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
        @Autowired
        private PostRepository repository;

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private PostService postService;
        @Autowired
        private User user;


    @GetMapping("/all")
    public ResponseEntity<List<PostResponseDto>> getAllPosts()
    {
        System.out.println("Received request for Get All Contents: " );
        List<Post> all = repository.findAll();

        List<PostResponseDto> allResponses = new ArrayList<>();
        for (Post post : all)
        {
            user =post.getUser();
            System.out.println("inside user Obj :"+user);
            PostResponseDto postResponse = new PostResponseDto();
            postResponse.setId(post.getId());
            postResponse.setContent(post.getContent());
            postResponse.setName(user.getName());
            postResponse.setLikes(post.getLikes());
            allResponses.add(postResponse);

        }
        return ResponseEntity.ok(allResponses);
    }

    @GetMapping("/myposts")
    public ResponseEntity<List<PostResponseDto>> getAllMyPosts()
    {
        System.out.println("Received request for Get All My Posts: ");

        String currentUserEmail = postService.getCurrentUsername();
        User currentUser = userRepository.findByEmail(currentUserEmail);

        List<Post> userPosts = repository.findByUser(currentUser);

        List<PostResponseDto> userPostsResponses = new ArrayList<>();
        for (Post post : userPosts)
        {
            User postUser = post.getUser();
            System.out.println("Inside user object: " + postUser);

            PostResponseDto postResponse = new PostResponseDto();
            postResponse.setId(post.getId());
            postResponse.setContent(post.getContent());
            postResponse.setName(postUser.getName());
            postResponse.setLikes(post.getLikes());
            userPostsResponses.add(postResponse);
        }

        return ResponseEntity.ok(userPostsResponses);
    }



    @PostMapping("/add")
        public ResponseEntity<Post> addPost(@RequestBody PostDto postDto)
        {
            System.out.println("Received request for Add Content: " +postDto);
            String userEmail= postService.getCurrentUsername();
            System.out.println("Creator email is : "+ userEmail);
            Post post = new Post();
            post.setContent(postDto.getContent());
            post.setUser(userRepository.findByEmail(userEmail));
            Post addPost = repository.save(post);

            System.out.println("Content added successful!");
            return ResponseEntity.ok(addPost);
        }

    @PutMapping("/update/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody PostDto postDto)
    {
        System.out.println("Received request to Update Content: " +postDto);
        String currentUserEmail = postService.getCurrentUsername();
        Post existingPost = repository.findById(postId).orElse(null);

        if (existingPost == null) {
            return ResponseEntity.notFound().build();
        }
        if (!existingPost.getUser().getEmail().equals(currentUserEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        }

        existingPost.setContent(postDto.getContent());
        Post updated = repository.save(existingPost);

        System.out.println("Content added successful!");
        return ResponseEntity.ok(updated);
    }
    @PostMapping("/like/{postId}")
    public ResponseEntity<String> addLike(@PathVariable Long postId)
    {
        Post post = repository.findById(postId).orElse(null);

        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        String userEmail = postService.getCurrentUsername();
        Long currentUserId =userRepository.findByEmail(userEmail).getId();
        System.out.println("Current User Id is :"+currentUserId);
        post.toggleLike(currentUserId);
        repository.save(post);

        return ResponseEntity.ok("Like added successfully");
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId)
    {
        System.out.println("Received request to Delete Content the ID is : "+postId);
        String currentUserEmail = postService.getCurrentUsername();
        Post existingPost = repository.findById(postId).orElse(null);

        if (existingPost == null) {
            return ResponseEntity.notFound().build();
        }

        if (!existingPost.getUser().getEmail().equals(currentUserEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        repository.delete(existingPost);

        System.out.println("Content deleted successfully!!");
        return ResponseEntity.ok("Content deleted successfully!!");
    }
    @PostMapping("/search")
    public ResponseEntity<List<Post>> searchPosts(@RequestBody SearchRequestDto searchRequest) {
        String content = searchRequest.getContent();
        System.out.println("Received request to search Content: " + content);

        if (content != null && content.length() >= 1) {
            List<Post> posts = repository.findByContentContaining(content);
            return ResponseEntity.ok(posts);
        } else {
            List<Post> allPosts = repository.findAll();
            return ResponseEntity.ok(allPosts);
        }
    }


}


