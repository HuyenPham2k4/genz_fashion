package com.example.back_end.Service;

import com.example.back_end.Model.User;
import com.example.back_end.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Đăng ký user mới
    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setIsActive(true);
        user.setCreatedAt(new Date());

        return userRepository.save(user);
    }

    // Đăng nhập user
    public User login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (!user.getIsActive()) {
                throw new RuntimeException("Account is inactive");
            }

            if (passwordEncoder.matches(password, user.getPasswordHash())) {
                return user;
            } else {
                throw new RuntimeException("Invalid password");
            }

        } else {
            throw new RuntimeException("User not found");
        }
    }

    // Lấy tất cả user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Lấy user theo id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Tạo mới user (CRUD - không dùng cho đăng ký)
    public User createUser(User user) {
        // Băm mật khẩu nếu tạo user từ admin
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    // Cập nhật user
    public User updateUser(Long id, User userDetails) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());

            // Nếu mật khẩu mới khác mật khẩu cũ -> mã hóa lại
            if (!userDetails.getPasswordHash().equals(user.getPasswordHash())) {
                user.setPasswordHash(passwordEncoder.encode(userDetails.getPasswordHash()));
            }

            user.setFullName(userDetails.getFullName());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setAddressId(userDetails.getAddressId());
            user.setRole(userDetails.getRole());
            user.setIsActive(userDetails.getIsActive());
            user.setUpdatedAt(new Date());

            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    // Xóa user theo id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
