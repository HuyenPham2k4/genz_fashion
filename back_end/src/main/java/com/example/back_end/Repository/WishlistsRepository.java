package com.example.back_end.Repository;

import com.example.back_end.Model.Wishlists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistsRepository extends JpaRepository<Wishlists, Long> {

}
