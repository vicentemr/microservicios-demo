package com.example.store.product.service;

import com.example.store.product.entity.Category;
import com.example.store.product.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> listAllProduct();
    public Product getProduct(Long id);

    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public  Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id, Double quantity);
}
