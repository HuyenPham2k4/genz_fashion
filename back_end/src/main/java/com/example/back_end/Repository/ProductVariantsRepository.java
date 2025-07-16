package com.example.back_end.Repository;

import com.example.back_end.Model.ProductVariants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantsRepository extends JpaRepository<ProductVariants, Long> {
    // ...existing code...
}
