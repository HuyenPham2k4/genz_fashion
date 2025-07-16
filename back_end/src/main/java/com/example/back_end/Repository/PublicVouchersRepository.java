package com.example.back_end.Repository;

import com.example.back_end.Model.PublicVouchers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicVouchersRepository extends JpaRepository<PublicVouchers, Long> {
    // ...custom queries if needed...
}

