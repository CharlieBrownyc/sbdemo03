package kr.co.brownyc.complete.controller;

import kr.co.brownyc.complete.dto.ProductDto;
import kr.co.brownyc.complete.service.ProductSearchService;
import kr.co.brownyc.complete.service.ProductSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductSearchService productSearchService;
    private final ProductSyncService productSyncService;

    @GetMapping("/products")
    public String showForm(Model model) {
//        log.info("ProductController:: showForm:");
        System.out.println("ProductController:: showForm:");
        model.addAttribute("productDto", new ProductDto());
        return "product";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("productDto") ProductDto productDto) {
//        log.info("ProductController:: saveProduct:productDto="+productDto.getName());
//        log.info("ProductController:: saveProduct:productDto="+productDto.getContent());
        System.out.println("ProductController:: saveProduct:productDto="+productDto.getName());
        System.out.println("ProductController:: saveProduct:productDto="+productDto.getContent());
        productSyncService.add(productDto);
        return "redirect:/products";
    }
}
