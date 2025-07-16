package com.example.back_end.Repository;

import com.example.back_end.Model.PointsTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsTransactionsRepository extends JpaRepository<PointsTransactions, Long> {
    // ...custom queries if needed...
}

