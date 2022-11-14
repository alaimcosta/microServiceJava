package br.com.alaim.controller;

import br.com.alaim.dto.ProductDTO;
import br.com.alaim.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<ProductDTO> getProducts() {
        List<ProductDTO> produtos = productService.getAll();

        return produtos;
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {

        List<ProductDTO> produtos = productService.getProductByCategoryId(categoryId);
        return produtos;
    }

    @GetMapping("/product/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier) {
        return productService
                .findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO newProduct(
            @Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }


/*    @DeleteMapping("/product/{id}")
    ProductDTO delete(@PathVariable Long id)
            throws ProductNotFoundException {
        return productService.delete(id);
    }*/

}
