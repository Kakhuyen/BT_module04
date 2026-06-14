package com.codegym.cart.service;

import com.codegym.cart.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {

        products.add(
                new Product(
                        1L,
                        "Product 1",
                        350000,
                        "https://picsum.photos/300?1",
                        "Description 1"
                )
        );

        products.add(
                new Product(
                        2L,
                        "Product 2",
                        400000,
                        "https://picsum.photos/300?2",
                        "Description 2"
                )
        );

        products.add(
                new Product(
                        3L,
                        "Product 3",
                        500000,
                        "https://picsum.photos/300?3",
                        "Description 3"
                )
        );

        products.add(
                new Product(
                        4L,
                        "Product 4",
                        600000,
                        "https://picsum.photos/300?4",
                        "Description 4"
                )
        );
    }

    @Override
    public List<Product> findAll() {

        return products;
    }

    @Override
    public Product findById(Long id) {

        for (int i = 0; i < products.size(); i++) {

            Product product = products.get(i);

            if (product.getId().equals(id)) {

                return product;
            }
        }

        return null;
    }
}