package com.example.back_end.Controller;

import com.example.back_end.Model.Brands;
import com.example.back_end.Service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    // Lấy tất cả brands
    @GetMapping("/findAll")
    public List<Brands> getAllBrands() {
        return brandsService.getAllBrands();
    }

    // Lấy brand theo id
    @GetMapping("/{id}")
    public ResponseEntity<Brands> getBrandById(@PathVariable Long id) {
        return brandsService.getBrandById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tạo mới brand
    @PostMapping("/create")
    public Brands createBrand(@RequestBody Brands brand) {
        return brandsService.createBrand(brand);
    }

    // Cập nhật brand theo id
    @PutMapping("/update/{id}")
    public ResponseEntity<Brands> updateBrand(@PathVariable Long id, @RequestBody Brands brandDetails) {
        try {
            Brands updatedBrand = brandsService.updateBrand(id, brandDetails);
            return ResponseEntity.ok(updatedBrand);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa brand theo id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandsService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
