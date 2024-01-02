package org.example.chuabaitap2.service;

import org.example.chuabaitap2.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 15", "35.000.000", "luxury", "apple"));
        products.put(2, new Product(2, "Iphone 14", "30.000.000", "luxury", "apple"));
        products.put(3, new Product(3, "Iphone 13", "25.000.000", "luxury", "apple"));
        products.put(4, new Product(4, "Iphone 12", "20.000.000", "luxury", "apple"));
        products.put(5, new Product(5, "Iphone 11", "15.000.000", "luxury", "apple"));
        products.put(6, new Product(6, "Iphone X", "10.000.000", "luxury", "apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void edit(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String searchMSG) {
        List<Product> productList = findAll();
        List<Product> newProductList = new ArrayList<>();
        for (Product product : productList){
            if (product.getName().contains(searchMSG)){
                newProductList.add(product);
            }
        }
        return newProductList;
    }
}
