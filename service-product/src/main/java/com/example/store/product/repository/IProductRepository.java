package com.example.store.product.repository;

import com.example.store.product.entity.Category;
import com.example.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
