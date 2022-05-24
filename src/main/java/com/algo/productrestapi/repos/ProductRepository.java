package com.algo.productrestapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algo.productrestapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
