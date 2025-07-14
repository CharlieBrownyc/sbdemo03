package kr.co.brownyc.complete.repository;

import kr.co.brownyc.complete.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
