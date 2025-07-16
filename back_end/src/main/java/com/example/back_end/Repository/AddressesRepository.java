package com.example.back_end.Repository;

import com.example.back_end.Model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AddressesRepository extends JpaRepository<Addresses, Long> {
}
