package kr.co.brownyc.complete.service;

import kr.co.brownyc.complete.dto.ProductDto;
import kr.co.brownyc.complete.entity.Product;
import kr.co.brownyc.complete.entity.ProductDocument;
import kr.co.brownyc.complete.repository.ProductRepository;
import kr.co.brownyc.complete.repository.ProductSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductSearchService {

    private final ProductRepository productRepository;
    private final ProductSearchRepository productSearchRepository;

    public List<String> searchByKeyword(String keyword) {
        return productSearchRepository.findByNameContaining(keyword)
                .stream()
                .map(ProductDocument::getName)
                .collect(Collectors.toList());
    }

    public Map<String, Object> searchTitle(String title) {

        List<ProductDocument> productDocuments = productSearchRepository.findByNameContaining(title);

        Map<String, Object> result = new HashMap<>();

        result.put("count", productDocuments.size());

        List<ProductDto> productDtoList = new ArrayList<>();
        for(ProductDocument pd : productDocuments) {
            ProductDto dto = new ProductDto();
            dto.setName(pd.getName());
            dto.setContent(pd.getContent());
            productDtoList.add(dto);
        }
        result.put("data", productDtoList);

        return result;
    }

    public void indexAll() {
        List<Product> products = productRepository.findAll();

        // list
        List<ProductDocument> documents = products.stream()
                .map(p ->
                        new ProductDocument(
                                p.getId(),
                                p.getName(),
                                p.getContent()))
                .collect(Collectors.toList());
        List<ProductDocument> docs = (List<ProductDocument>) productSearchRepository.saveAll(documents);
        System.out.println("indexAll: docs.size=" + docs.size());

        // Step by Step
//        for (Product product : products) {
//            ProductDocument productDocument = new ProductDocument();
//            productDocument.setId(product.getId());
//            productDocument.setName(product.getName());
//            productDocument.setContent(product.getContent());
//            productSearchRepository.save(productDocument);
//        }
    }

}
