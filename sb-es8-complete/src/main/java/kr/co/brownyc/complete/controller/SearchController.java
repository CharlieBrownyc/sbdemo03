package kr.co.brownyc.complete.controller;

import kr.co.brownyc.complete.service.ProductSearchService;
import kr.co.brownyc.complete.service.ProductSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final ProductSearchService productSearchService;
    private final ProductSyncService productSyncService;

    @GetMapping
    public List<String> autocomplete(@RequestParam String query) {
        log.info("query=" + query);
        List<String> ret = productSearchService.searchByKeyword(query);
        log.info("ret=" + ret);
        return ret;
    }

}
