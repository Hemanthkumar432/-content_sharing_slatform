package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Repo;

import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.Post;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM Post p WHERE p.content LIKE %:content%", nativeQuery = true)
    List<Post> findByContentContaining(@Param("content") String content);

    List<Post> findByUser(User currentUser);
}

