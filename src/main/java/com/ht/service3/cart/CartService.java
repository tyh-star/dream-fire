package com.ht.service3.cart;

import com.ht.model.CartDomain;
import java.util.List;

public interface CartService {
    void addToCart(Long userId, Long productId, int quantity);
    List<CartDomain> getCartItems(Long userId);
    void updateCartItem(Long userId, Long productId, int quantity);
    void removeCartItem(Long userId, Long productId);
    void clearCart(Long userId);
}

