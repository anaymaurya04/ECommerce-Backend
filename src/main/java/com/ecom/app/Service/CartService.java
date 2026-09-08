package com.ecom.app.Service;

import com.ecom.app.DTO.CartItemRequest;
import com.ecom.app.Model.CartItem;
import com.ecom.app.Model.Product;
import com.ecom.app.Model.User;
import com.ecom.app.Repository.CartItemRepository;
import com.ecom.app.Repository.ProductRepository;
import com.ecom.app.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public boolean addToCart(String userId, CartItemRequest request) {
        Optional<Product> productOpt = productRepository.findById(request.getProduct_id());
        if (productOpt.isEmpty()) {
            return false;
        }
        Product product = productOpt.get();
        if (product.getQuantity() < request.getQuantity()) {
            return false;
        }
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if (userOpt.isEmpty()) {
            return false;
        }
        User user = userOpt.get();
        CartItem existingCartItem = cartItemRepository.findByUserAndProduct(user, product);

        if (existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + request.getQuantity());
            cartItemRepository.save(existingCartItem);
        } else {
            CartItem newCartItem = new CartItem();
            newCartItem.setUser(user);
            newCartItem.setProduct(product);
            newCartItem.setQuantity(request.getQuantity());
            newCartItem.setPrice(product.getPrice());
            cartItemRepository.save(newCartItem);
        }
        return true;
    }

    public List<CartItem> getCartItems(String userId) {
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if (userOpt.isEmpty()) {
            return List.of();
        }
        return cartItemRepository.findByUser(userOpt.get());
    }

    public boolean removeFromCart(String userId, Long productId) {
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        Optional<Product> productOpt = productRepository.findById(productId);
        if (userOpt.isEmpty() || productOpt.isEmpty()) {
            return false;
        }
        CartItem cartItem = cartItemRepository.findByUserAndProduct(userOpt.get(), productOpt.get());
        if (cartItem != null) {
            cartItemRepository.delete(cartItem);
            return true;
        }
        return false;
    }
}
