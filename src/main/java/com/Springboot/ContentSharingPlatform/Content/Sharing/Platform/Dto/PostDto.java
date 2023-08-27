package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto;

import com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto
{
    private Long userId;
    private String content;

}
