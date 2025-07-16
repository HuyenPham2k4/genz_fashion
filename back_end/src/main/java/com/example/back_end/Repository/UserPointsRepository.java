package com.example.back_end.Repository;

import com.example.back_end.Model.UserPoints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointsRepository extends JpaRepository<UserPoints, Long> {
    // ...custom queries if needed...
}

