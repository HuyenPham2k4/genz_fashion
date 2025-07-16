package com.example.back_end.Repository;

import com.example.back_end.Model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
}
