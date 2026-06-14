package com.codegym.cart.service;

import com.codegym.cart.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);
}