package com.gokhan.myshops.service.product;

import com.gokhan.myshops.exceptions.ProductNotFoundExxception;
import com.gokhan.myshops.model.Category;
import com.gokhan.myshops.model.Product;
import com.gokhan.myshops.repository.ICategoryRepository;
import com.gokhan.myshops.repository.IProductRepository;
import com.gokhan.myshops.requests.AddProductRequests;
import com.gokhan.myshops.requests.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private IProductRepository productRepository;
    private ICategoryRepository categoryRepository;
    @Override
    public Product addProduct(AddProductRequests product) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->new ProductNotFoundExxception("product not found!") );
    }
public Product createProduct(AddProductRequests request, Category category) {
return  new Product(
        request.getName(),
        request.getBrand(),
        request.getDescription(),
        request.getPrice(),
        request.getInventory(),
        category);

}
    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete,
                () -> {throw  new ProductNotFoundExxception("product not found!");});
    }


    @Override
    public Product updateProduct(ProductUpdateRequest  request, Long productId) {
return  productRepository.findById(productId)
        .map(existingProduct->updateExistingProduct(existingProduct,request))
        .map(productRepository ::save)
        .orElseThrow(() ->new ProductNotFoundExxception("product not found!") );
    }
    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request) {
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        Category category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);
        return existingProduct;

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return productRepository.findByBrandName(brand);
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCAtegoryNameAndBrand(category,brand);
    }

    @Override
    public List<Product> getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public List<Product> getProductByBrandAndName(String brand, String productName) {
        return productRepository.findBrandAndName(brand,productName);
    }

    @Override
    public long countProductByBrandAndName(String brand, String name) {
        return getProductByBrandAndName(brand, name).size();
    }
}
