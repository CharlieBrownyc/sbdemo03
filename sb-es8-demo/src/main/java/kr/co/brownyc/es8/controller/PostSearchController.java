package kr.co.brownyc.es8.controller;

import kr.co.brownyc.es8.dto.PostRequestDto;
import kr.co.brownyc.es8.entity.Post;
import kr.co.brownyc.es8.entity.PostDocument;
import kr.co.brownyc.es8.service.PostSearchService;
import kr.co.brownyc.es8.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostSearchController {

    private final PostSearchService postSearchService;
    private final PostService postService;

    @GetMapping("/search")
    ResponseEntity<List<PostDocument>> search(@RequestParam String keyword) {
//        log.info("PostSearchController:: search: keyword=" + keyword);
        return ResponseEntity.ok(postSearchService.searchByKeyword(keyword));
    }

    @PostMapping
    public ResponseEntity<Post> input(@RequestBody PostRequestDto dto) {
        return ResponseEntity.ok(postService.add(dto));
    }
}
