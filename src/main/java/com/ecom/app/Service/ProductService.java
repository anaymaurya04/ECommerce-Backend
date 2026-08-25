package com.ecom.app.Service;

import com.ecom.app.DTO.ProductRequest;
import com.ecom.app.DTO.ProductResponse;
import com.ecom.app.Model.Product;
import com.ecom.app.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        updateProductFromRequest(product, productRequest);
        Product savedProduct = productRepository.save(product);
        return mapToProductObject(savedProduct);
    }

    private ProductResponse mapToProductObject(Product savedProduct) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(savedProduct.getId());
        productResponse.setName(savedProduct.getName());
        productResponse.setCategory(savedProduct.getCategory());
        productResponse.setDescription(savedProduct.getDescription());
        productResponse.setImage_url(savedProduct.getImage_url());
        productResponse.setPrice(savedProduct.getPrice());
        productResponse.setQuantity(savedProduct.getQuantity());
        productResponse.setActive(savedProduct.isActive());
        return productResponse;
    }

    private void updateProductFromRequest(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setDescription(productRequest.getDescription());
        product.setImage_url(productRequest.getImage_url());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
    }
}
