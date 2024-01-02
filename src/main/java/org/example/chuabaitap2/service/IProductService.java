package org.example.chuabaitap2.service;

import org.example.chuabaitap2.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void create(Product product);
    void edit(int id, Product product);
    void delete(int id);
    List<Product> search(String searchMSG);
}
