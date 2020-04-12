package com.nwt.witcher.paymentapp.service;

import java.util.List;

import com.nwt.witcher.paymentapp.model.Product;

public interface ProductService {

    List<Product> get();

    Product get(int id);

    void save(Product product);

    void delete(int id);
}
