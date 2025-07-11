package kr.co.brownyc.esdemo.service;

import kr.co.brownyc.esdemo.entity.Item;
import kr.co.brownyc.esdemo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Optional<Item> getItemById(String id){
        return itemRepository.findById(id);
    }

    public Item addItem(Item item) { // CREATE(생성) 서비스
        return itemRepository.save(item);
    }

    public Optional<Item> getItemByItemId(String itemId) { // READ(읽기) 서비스
        return itemRepository.findByItemId(itemId);
    }

    public Item updateItem(String itemId, Item updatedItem) { // UPDATE(수정) 서비스
        Optional<Item> existingItem = itemRepository.findByItemId(itemId); // itemId를 기준으로 기존 아이템 조회

        if (existingItem.isPresent()){
            // 주의! Elasticsearch에서는 객체의 id 필드가 문서의 고유 식별자로 사용됩니다.
            // 만약 id를 updatedItem에 설정하지 않으면 새로운 문서로 간주하여 수정이 아닌 추가가 됩니다.
            updatedItem.setId(existingItem.get().getId()); // 기존 아이템의 ID를 업데이트할 아이템에 설정
            updatedItem.setItemId(itemId);
            return itemRepository.save(updatedItem); // 아이템을 업데이트한다.
        } else {
            return null; // 아이템번호로 조회시 데이터 없음
        }
    }

    public void deleteItem(String itemId) { // DELETE(삭제) 서비스
        itemRepository.deleteByItemId(itemId);
    }

}
