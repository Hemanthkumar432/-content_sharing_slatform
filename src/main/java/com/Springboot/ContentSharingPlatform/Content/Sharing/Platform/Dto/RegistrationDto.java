package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDto
{
    private String name;
    private String email;
    private String password;

}
