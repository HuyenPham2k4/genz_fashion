package com.example.back_end.Service;

import com.example.back_end.Model.Cart;
import com.example.back_end.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart cartDetails) {
        Optional<Cart> cartOpt = cartRepository.findById(id);
        if (cartOpt.isPresent()) {
            Cart cart = cartOpt.get();
            cart.setUserId(cartDetails.getUserId());
            cart.setCreatedAt(cartDetails.getCreatedAt());
            cart.setUpdatedAt(cartDetails.getUpdatedAt());
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Cart not found with id " + id);
        }
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}

