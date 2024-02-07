package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("Product A", 100));
        products.add(new Product("Product B", 200));
        products.add(new Product("Product D", 300));
        products.add(new Product("Product C", 150));
    }

    public List<Product> getProducts() {
        return products;
    }

}
