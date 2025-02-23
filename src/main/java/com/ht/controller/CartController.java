package com.ht.controller;

import com.ht.model.CartDomain;
import com.ht.service3.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok("商品已成功添加到购物车！");
    }

    @GetMapping("/items")
    public ResponseEntity<List<CartDomain>> getCartItems(@RequestParam Long userId) {
        return ResponseEntity.ok(cartService.getCartItems(userId));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCartItem(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.updateCartItem(userId, productId, quantity);
        return ResponseEntity.ok("购物车商品已更新！");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeCartItem(@RequestParam Long userId, @RequestParam Long productId) {
        cartService.removeCartItem(userId, productId);
        return ResponseEntity.ok("商品已从购物车移除！");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(@RequestParam Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("购物车已清空！");
    }
}



