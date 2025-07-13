package kr.co.brownyc.es8.repository;

import kr.co.brownyc.es8.entity.PostDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PostElasticRepository extends ElasticsearchRepository<PostDocument, Long> {
    List<PostDocument> findByTitle(String title);
}
