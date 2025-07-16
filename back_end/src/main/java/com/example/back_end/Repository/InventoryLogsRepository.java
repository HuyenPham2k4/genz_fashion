package com.example.back_end.Repository;

import com.example.back_end.Model.InventoryLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryLogsRepository extends JpaRepository<InventoryLogs, Long> {
    // ...custom queries if needed...
}
