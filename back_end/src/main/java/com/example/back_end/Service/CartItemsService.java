package com.example.back_end.Service;

import com.example.back_end.Model.CartItems;
import com.example.back_end.Repository.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemsService {

    @Autowired
    private CartItemsRepository cartItemsRepository;

    public List<CartItems> getAllCartItems() {
        return cartItemsRepository.findAll();
    }

    public Optional<CartItems> getCartItemById(Long id) {
        return cartItemsRepository.findById(id);
    }

    public CartItems createCartItem(CartItems cartItem) {
        return cartItemsRepository.save(cartItem);
    }

    public CartItems updateCartItem(Long id, CartItems cartItemDetails) {
        Optional<CartItems> cartItemOpt = cartItemsRepository.findById(id);
        if (cartItemOpt.isPresent()) {
            CartItems cartItem = cartItemOpt.get();
            cartItem.setCartId(cartItemDetails.getCartId());
            cartItem.setVariantId(cartItemDetails.getVariantId());
            cartItem.setQuantity(cartItemDetails.getQuantity());
            cartItem.setUnitPrice(cartItemDetails.getUnitPrice());
            cartItem.setTotalPrice(cartItemDetails.getTotalPrice());
            cartItem.setAddedAt(cartItemDetails.getAddedAt());
            return cartItemsRepository.save(cartItem);
        } else {
            throw new RuntimeException("CartItem not found with id " + id);
        }
    }

    public void deleteCartItem(Long id) {
        cartItemsRepository.deleteById(id);
    }
}
