package kr.co.brownyc.esdemo.repository;

import kr.co.brownyc.esdemo.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ItemRepository extends ElasticsearchRepository<Item, String> {

    Optional<Item> findByItemId(String itemId); // Read

    void deleteByItemId(String itemId); // Delete
}
