package com.example.back_end.Controller;

import com.example.back_end.Model.Products;
import com.example.back_end.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("findAll")
    public List<Products> getAll() {
        return productService.getAllProduct();
    }

    // Placeholder for save and update endpoints
    @PostMapping("/saved")
    public Products saved(@RequestBody Products product) {
        // Implement save logic or delegate to a service as needed
        throw new UnsupportedOperationException("Save operation not implemented yet.");
    }

    @PostMapping("/update")
    public ResponseEntity<?> updated(@RequestBody Products product) {
        try {
            // Implement update logic or delegate to a service as needed
            throw new UnsupportedOperationException("Update operation not implemented yet.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
        }
    }
}
