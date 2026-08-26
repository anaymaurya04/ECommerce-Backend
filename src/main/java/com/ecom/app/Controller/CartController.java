package com.ecom.app.Controller;

import com.ecom.app.DTO.CartItemRequest;
import com.ecom.app.Model.CartItem;
import com.ecom.app.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Void> addToCart(@RequestHeader("X-User-ID") String userId, @RequestBody CartItemRequest request){
        cartService.addToCart(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
