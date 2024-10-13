package com.gokhan.myshops.repository;

import com.gokhan.myshops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String category);

    List<Product> findByBrandName(String brand);

    List<Product> findByCAtegoryNameAndBrand(String category, String brand);

    List<Product> findByName(String productName);

    List<Product> findBrandAndName(String brand, String productName);
}
