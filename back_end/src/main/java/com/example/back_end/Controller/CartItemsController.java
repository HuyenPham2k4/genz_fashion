package com.example.back_end.Controller;

import com.example.back_end.Model.CartItems;
import com.example.back_end.Service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart-items")
public class CartItemsController {

    @Autowired
    private CartItemsService cartItemsService;

    @GetMapping("/findAll")
    public List<CartItems> getAllCartItems() {
        return cartItemsService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItems> getCartItemById(@PathVariable Long id) {
        return cartItemsService.getCartItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public CartItems createCartItem(@RequestBody CartItems cartItem) {
        return cartItemsService.createCartItem(cartItem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartItems> updateCartItem(@PathVariable Long id, @RequestBody CartItems cartItemDetails) {
        try {
            CartItems updatedCartItem = cartItemsService.updateCartItem(id, cartItemDetails);
            return ResponseEntity.ok(updatedCartItem);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemsService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}

