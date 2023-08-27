package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Repo;

import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    User findByEmail(String email);
}
