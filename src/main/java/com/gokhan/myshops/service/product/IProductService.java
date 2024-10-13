package com.gokhan.myshops.service.product;

import com.gokhan.myshops.model.Product;
import com.gokhan.myshops.requests.AddProductRequests;
import com.gokhan.myshops.requests.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequests product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId );
    List<Product> getAllProduct();
    List<Product> getProductByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByCategoryAndBrand(String category, String brand);
    List<Product> getProductByName(String productName);
    List<Product> getProductByBrandAndName(String brand, String productName);
    long countProductByBrandAndName(String brand,String name);
}
