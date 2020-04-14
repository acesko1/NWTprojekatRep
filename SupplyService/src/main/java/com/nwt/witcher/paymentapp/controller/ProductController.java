package com.nwt.witcher.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwt.witcher.paymentapp.model.Product;
import com.nwt.witcher.paymentapp.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> get() {
        return productService.get();
    }

    @PostMapping("/product")
    public Product save(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @GetMapping("/product/{id}")
    public Product get(@PathVariable int id) {
        Product productObj = productService.get(id);
        if (productObj == null) {
            throw new RuntimeException("Proizvod sa id-om:" + id + "nije pronađen");
        }
        return productObj;
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "Proizvod je obrisan sa id-om:" + id;
    }

    @PutMapping("/product")
    public Product update(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

}
