package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Controller;

import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto.RegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Navigationcontroller {
    @GetMapping("/registration")
    public String signup(Model model) {
        model.addAttribute("user", new RegistrationDto());
        return "register";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/")
    public String base(){
        return "login";
    }
    @GetMapping("/home")
    public String home(){
        return "homepage";
    }

    @GetMapping("/createPost")
    public String createPost() {return "createPost";}

}
