package com.ecom.app.Service;

import com.ecom.app.DTO.CartItemRequest;
import com.ecom.app.Model.Product;
import com.ecom.app.Model.User;
import com.ecom.app.Repository.CartItemRepository;
import com.ecom.app.Repository.ProductRepository;
import com.ecom.app.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    public boolean addToCart(String userId, CartItemRequest request) {
        Optional<Product> productOpt = productRepository.findById(request.getProduct_id());
        if (productOpt.isEmpty()){
            return false;
        }
        Product product = productOpt.get();
        if (product.getQuantity() < request.getQuantity()){
            return false;
        }
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isEmpty()){
            return false;
        }
        User user = userOpt.get();
    }
}
