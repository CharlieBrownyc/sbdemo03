package kr.co.brownyc.complete.controller;

import kr.co.brownyc.complete.service.ProductSearchService;
import kr.co.brownyc.complete.service.ProductSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SearchController {

    private final ProductSearchService productSearchService;

    @GetMapping("/v1/search")
    public List<String> autocomplete(@RequestParam String query) {
//        log.info("query=" + query);
        System.out.println("query=" + query);

        List<String> ret = productSearchService.searchByKeyword(query);

//        log.info("ret=" + ret);
        System.out.println(("ret=" + ret));

        return ret;
    }

    @GetMapping("/v2/search")
    public ResponseEntity<Map<String, Object>> getList(@RequestParam String query) {
        System.out.println("query=" + query);

        return new ResponseEntity<>(productSearchService.searchTitle(query), HttpStatus.OK);
    }



}
