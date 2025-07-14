package kr.co.brownyc.complete.service;

import kr.co.brownyc.complete.entity.ProductDocument;
import kr.co.brownyc.complete.repository.ProductSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductSearchService {
    private final ProductSearchRepository productSearchRepository;

    public List<String> searchByKeyword(String keyword) {
        return productSearchRepository.findByNameContaining(keyword)
                .stream()
                .map(ProductDocument::getName)
                .collect(Collectors.toList());
    }

}
