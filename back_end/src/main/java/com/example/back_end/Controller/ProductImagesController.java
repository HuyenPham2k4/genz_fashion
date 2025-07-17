package com.example.back_end.Controller;

import com.example.back_end.Model.ProductImages;
import com.example.back_end.Service.ProductImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-images")
public class ProductImagesController {

    @Autowired
    private ProductImagesService productImagesService;

    @GetMapping("/findAll")
    public List<ProductImages> getAllProductImages() {
        return productImagesService.getAllProductImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductImages> getProductImageById(@PathVariable Long id) {
        return productImagesService.getProductImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ProductImages createProductImage(@RequestBody ProductImages productImage) {
        return productImagesService.createProductImage(productImage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductImages> updateProductImage(@PathVariable Long id, @RequestBody ProductImages productImageDetails) {
        try {
            ProductImages updatedProductImage = productImagesService.updateProductImage(id, productImageDetails);
            return ResponseEntity.ok(updatedProductImage);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductImage(@PathVariable Long id) {
        productImagesService.deleteProductImage(id);
        return ResponseEntity.noContent().build();
    }
}

