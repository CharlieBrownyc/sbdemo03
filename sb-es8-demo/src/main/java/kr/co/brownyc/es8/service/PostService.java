package kr.co.brownyc.es8.service;

import kr.co.brownyc.es8.dto.PostRequestDto;
import kr.co.brownyc.es8.entity.Post;
import kr.co.brownyc.es8.entity.PostDocument;
import kr.co.brownyc.es8.repository.PostElasticRepository;
import kr.co.brownyc.es8.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostElasticRepository postElasticRepository;
    private final PostRepository postRepository;

    public Post add(PostRequestDto request) {
        Post post = Post.builder()
                .username(request.getUsername())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        postRepository.save(post);
        postElasticRepository.save(PostDocument.from(post));
        return post;
    }
}
