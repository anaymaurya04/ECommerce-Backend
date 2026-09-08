package com.ecom.app.Repository;

import com.ecom.app.Model.CartItem;
import com.ecom.app.Model.Product;
import com.ecom.app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserAndProduct(User user, Product product);
    List<CartItem> findByUser(User user);
}
