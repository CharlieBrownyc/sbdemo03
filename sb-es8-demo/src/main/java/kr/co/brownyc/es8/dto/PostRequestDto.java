package kr.co.brownyc.es8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostRequestDto {
    private String username;
    private String title;
    private String content;
}
