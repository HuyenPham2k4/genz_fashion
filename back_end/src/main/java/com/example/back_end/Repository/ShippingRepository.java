package com.example.back_end.Repository;

import com.example.back_end.Model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    // ...custom queries if needed...
}


