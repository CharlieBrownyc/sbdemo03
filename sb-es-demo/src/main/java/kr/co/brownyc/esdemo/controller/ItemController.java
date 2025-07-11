package kr.co.brownyc.esdemo.controller;

import kr.co.brownyc.esdemo.entity.Item;
import kr.co.brownyc.esdemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item savedItem = itemService.addItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/{itemId}")
    public Item getItem(@PathVariable String itemId) {
        return itemService.getItemByItemId(itemId).orElse(null);
    }


    @PostMapping("/update/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable String itemId, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(itemId, item);
        if (null != updatedItem) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/{itemId}")
    public ResponseEntity<?> deleteItemId(@PathVariable String itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
