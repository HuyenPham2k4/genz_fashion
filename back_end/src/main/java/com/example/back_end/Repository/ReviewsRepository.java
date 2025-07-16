package com.example.back_end.Repository;

import com.example.back_end.Model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    // ...existing code...
}
