package com.codegym.cart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public Cart() {
    }

    public List<CartItem> getItems() {
        return items;
    }


    private CartItem findItemByProduct(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                return item;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        CartItem item = findItemByProduct(product);
        if (item != null)
        {
            item.setQuantity(item.getQuantity() + 1);
        }
        else {

            items.add(new CartItem(product, 1));
        }
    }

    public void decreaseProduct(Product product) {
        CartItem item = findItemByProduct(product);
        if (item != null) {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
            } else {
                items.remove(item);
            }
        }
    }

    // Xóa hẳn sản phẩm
    public void removeProduct(Product product) {
        CartItem item = findItemByProduct(product);
        if (item != null) {
            items.remove(item);
        }
    }


    public void clear() {
        items.clear();
    }

    public Integer countItemQuantity() {
        return items.size();
    }


    public Integer countProductQuantity() {
        int totalQuantity = 0;
        for (CartItem item : items) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }

    public Float countTotalPayment() {
        float totalPayment = 0;
        for (CartItem item : items) {
            totalPayment += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPayment;
    }
}