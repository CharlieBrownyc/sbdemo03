package kr.co.brownyc.complete;

import kr.co.brownyc.complete.entity.Product;
import kr.co.brownyc.complete.repository.ProductRepository;
import kr.co.brownyc.complete.service.ProductSyncService;
import kr.co.brownyc.complete.util.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class ProductSyncServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSyncService productSyncService;

    @Test
    void contextLoads() {

    }

    @Test
    public void testAddDummy(){
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Product p = new Product();
            p.setName(NameGenerator.generateName());
            p.setContent(generateRandomKoreanString(20));

            Product sp = productRepository.save(p);
            logger.info("Saved Product: id={}, name={}, content={}",
                    sp.getId(), sp.getName(), sp.getContent());
        }

    }

    @Test
    public void syncDBtoES(){
        int size = productSyncService.syncAll();
        logger.info("DB sync ES:" + size);
    }

    private String generateRandomKoreanString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char koreanChar = (char) (0xAC00 + Math.random() * 11172);
            sb.append(koreanChar);
        }
        return sb.toString();
    }

}
