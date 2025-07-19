package kr.co.brownyc.streaming.service;

import kr.co.brownyc.streaming.dto.VideoFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class VideoListService {
    private final String DIR = "static/videos/";


    public List<VideoFileDto> getVideoList() throws IOException {
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = pathMatchingResourcePatternResolver.getResources(DIR + "*.*");

        List<VideoFileDto> videoFileDtoList = new ArrayList<>();

        long i = 0;
        for(Resource resource : resources) {
            VideoFileDto dto = new VideoFileDto();
            dto.setId(i++);
            dto.setFilename(resource.getFilename());
            dto.setFilesize(String.valueOf(resource.getFile().length()/1024)+"Kb");
            videoFileDtoList.add(dto);
        }

        videoFileDtoList.forEach(p -> System.out.println("fileName=" + p.getFilename()));

        return videoFileDtoList;
    }
}
