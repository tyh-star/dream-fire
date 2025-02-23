package com.ht.dao;

import com.ht.model.CartDomain;
import java.util.List;

public interface CartDao {
    List<CartDomain> findCartItemsByUserId(Long userId);
    CartDomain findCartItemByUserIdAndProductId(Long userId, Long productId);
    int insertCartItem(CartDomain cartItem);
    int updateCartItem(CartDomain cartItem);
    int deleteCartItem(Long cartId);
    int deleteAllCartItemsByUserId(Long userId);
}
