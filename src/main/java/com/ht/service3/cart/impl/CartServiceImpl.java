package com.ht.service3.cart.impl;

import com.ht.dao.CartDao;
import com.ht.model.CartDomain;
import com.ht.service3.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public void addToCart(Long userId, Long productId, int quantity) {
        CartDomain cartItem = cartDao.findCartItemByUserIdAndProductId(userId, productId);
        if (cartItem == null) {
            cartItem = new CartDomain();
            cartItem.setUserId(userId);
            cartItem.setProductId(productId);
            cartItem.setQuantity(quantity);
            cartDao.insertCartItem(cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartDao.updateCartItem(cartItem);
        }
    }

    @Override
    public List<CartDomain> getCartItems(Long userId) {
        return cartDao.findCartItemsByUserId(userId);
    }

    @Override
    public void updateCartItem(Long userId, Long productId, int quantity) {
        CartDomain cartItem = cartDao.findCartItemByUserIdAndProductId(userId, productId);
        if (cartItem == null) {
            throw new IllegalArgumentException("购物车中不存在该商品！");
        }
        cartItem.setQuantity(quantity);
        cartDao.updateCartItem(cartItem);
    }

    @Override
    public void removeCartItem(Long userId, Long productId) {
        CartDomain cartItem = cartDao.findCartItemByUserIdAndProductId(userId, productId);
        if (cartItem != null) {
            cartDao.deleteCartItem(cartItem.getCartId());
        }
    }

    @Override
    public void clearCart(Long userId) {
        cartDao.deleteAllCartItemsByUserId(userId);
    }
}
