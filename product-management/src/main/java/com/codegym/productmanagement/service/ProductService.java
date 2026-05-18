package com.codegym.productmanagement.service;

import com.codegym.productmanagement.model.Product;

import java.util.*;

public class ProductService
        implements IProductService {

    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();

        products.put(1,
                new Product(
                        1,
                        "IPhone",
                        1000,
                        "Phone",
                        "Apple"));

        products.put(2,
                new Product(
                        2,
                        "Galaxy",
                        900,
                        "Android Phone",
                        "Samsung"));
    }

    @Override
    public List<Product> findAll() {

        return new ArrayList<>(products.values());

    }

    @Override
    public void save(Product product) {

        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {

        return products.get(id);

    }

    @Override
    public void update(int id,
                       Product product) {

        products.put(id, product);

    }

    @Override
    public void remove(int id) {

        products.remove(id);

    }

    @Override
    public List<Product> searchByName(String name) {

        List<Product> result =
                new ArrayList<>();

        for (Product p : products.values()) {

            if (p.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                result.add(p);

            }
        }

        return result;
    }
}