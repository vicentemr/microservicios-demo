package com.example.store.product;

import com.example.store.product.entity.Category;
import com.example.store.product.entity.Product;
import com.example.store.product.repository.IProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

//@DataJpaTest
public class ProductRepositoryMockTest {
    @Autowired
    IProductRepository productRepository;
//    @Test
    public void whenFindByCategory_thenReturnListProduct() {
        Product product1 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1l).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();

        this.productRepository.save(product1);

        List<Product> founds = this.productRepository.findByCategory(product1.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
}
