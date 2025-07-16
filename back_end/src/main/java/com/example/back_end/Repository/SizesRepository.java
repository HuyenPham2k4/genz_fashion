package com.example.back_end.Repository;

import com.example.back_end.Model.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizesRepository extends JpaRepository<Sizes, Long> {
    // ...custom queries if needed...
}

