package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String content;
    private int likes;

    @ElementCollection
    private Set<Long> likedUserIds = new HashSet<>();

    public void toggleLike(Long userId) {
        if (likedUserIds.contains(userId)) {
            likedUserIds.remove(userId);
            likes--;
        } else {
            likedUserIds.add(userId);
            likes++;
        }
    }


}
