package com.ecom.app.DTO;

import lombok.Data;

@Data
public class CartItemRequest {
    private Long product_id;
    private Integer quantity;
}
