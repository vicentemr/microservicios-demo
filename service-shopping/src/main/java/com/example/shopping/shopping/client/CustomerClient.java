package com.example.shopping.shopping.client;

import com.example.shopping.shopping.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service", path = "/customers", fallback = CustomerHystrixFallbackFactory.class)
public interface CustomerClient {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
