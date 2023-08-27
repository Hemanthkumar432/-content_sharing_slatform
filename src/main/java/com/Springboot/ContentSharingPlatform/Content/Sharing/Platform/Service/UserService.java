package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Service;

import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.User;
@Service
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username);
    if(user == null){
        throw new UsernameNotFoundException("User not found");
    }
        return new CustomUserDetails(user);
    }
}
