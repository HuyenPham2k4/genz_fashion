package com.example.back_end.Controller;

import com.example.back_end.Model.ProductVariants;
import com.example.back_end.Service.ProductVariantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-variants")
public class ProductVariantsController {

    @Autowired
    private ProductVariantsService productVariantsService;

    @GetMapping("/findAll")
    public List<ProductVariants> getAllProductVariants() {
        return productVariantsService.getAllProductVariants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVariants> getProductVariantById(@PathVariable Long id) {
        return productVariantsService.getProductVariantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ProductVariants createProductVariant(@RequestBody ProductVariants productVariant) {
        return productVariantsService.createProductVariant(productVariant);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductVariants> updateProductVariant(@PathVariable Long id, @RequestBody ProductVariants productVariantDetails) {
        try {
            ProductVariants updatedProductVariant = productVariantsService.updateProductVariant(id, productVariantDetails);
            return ResponseEntity.ok(updatedProductVariant);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductVariant(@PathVariable Long id) {
        productVariantsService.deleteProductVariant(id);
        return ResponseEntity.noContent().build();
    }
}

