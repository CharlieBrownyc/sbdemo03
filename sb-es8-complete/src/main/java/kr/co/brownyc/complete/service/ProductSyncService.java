package kr.co.brownyc.complete.service;

import kr.co.brownyc.complete.dto.ProductDto;
import kr.co.brownyc.complete.entity.Product;
import kr.co.brownyc.complete.entity.ProductDocument;
import kr.co.brownyc.complete.repository.ProductRepository;
import kr.co.brownyc.complete.repository.ProductSearchRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSyncService {

    private final ProductRepository productRepository;
    private final ProductSearchRepository productSearchRepository;

    public void add(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .content(productDto.getContent())
                .build();
        productRepository.save(product);
        productSearchRepository.save(ProductDocument.from(product));
    }

    public int syncAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDocument> documents = products.stream()
                .map(p ->
                        new ProductDocument(
                                p.getId(),
                                p.getName(),
                                p.getContent()))
                .collect(Collectors.toList());
        List<ProductDocument> docs = (List<ProductDocument>) productSearchRepository.saveAll(documents);
        return docs.size();
    }

}
