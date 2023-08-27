package com.Springboot.ContentSharingPlatform.Content.Sharing.Platform.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String name;
    private String content;
    private int likes;
}
