package kr.co.brownyc.streaming.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VideoFileDto {

    private Long id;
    private String filename;
    private String filesize;
}
