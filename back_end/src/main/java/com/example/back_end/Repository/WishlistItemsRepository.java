package com.example.back_end.Repository;

import com.example.back_end.Model.WishlistItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemsRepository extends JpaRepository<WishlistItems, Long> {
    // ...custom queries if needed...
}

