package com.example.back_end.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.back_end.Model.UserVoucherUsage;

@Repository
public interface UserVoucherUsageRepository extends JpaRepository<UserVoucherUsage, Long> {
    // ...existing code...
}
