package kr.co.brownyc.es8.service;

import kr.co.brownyc.es8.entity.PostDocument;
import kr.co.brownyc.es8.repository.PostElasticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostSearchService {
    private final PostElasticRepository postElasticRepository;

    public List<PostDocument> searchByKeyword(String keyword) {
        return postElasticRepository.findByTitle(keyword);
    }
}
