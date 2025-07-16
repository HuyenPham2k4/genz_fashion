package com.example.back_end.Repository;

import com.example.back_end.Model.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorsRepository extends JpaRepository<Colors, Long> {
    // ...existing code...
}
