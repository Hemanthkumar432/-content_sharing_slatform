package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Controller;

import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto.RegistrationDto;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.User;
import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationDto registrationDto)
    {
        System.out.println("Received request for REGISTER USER: " + registrationDto);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        String hashedPassword = passwordEncoder.encode(registrationDto.getPassword());
        user.setPassword(hashedPassword);

        User addedUser = userRepository.save(user);

        System.out.println("User registration successful!");
        return ResponseEntity.ok(addedUser);
    }


}

