package com.example.back_end.Repository;


import com.example.back_end.Model.UserOAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOAuthRepository extends JpaRepository<UserOAuth, Long> {
}

