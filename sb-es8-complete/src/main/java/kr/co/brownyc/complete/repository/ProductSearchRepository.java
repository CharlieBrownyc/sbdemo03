package kr.co.brownyc.complete.repository;

import kr.co.brownyc.complete.entity.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductSearchRepository extends ElasticsearchRepository<ProductDocument, String> {
    List<ProductDocument> findByNameContaining(String name);
}
