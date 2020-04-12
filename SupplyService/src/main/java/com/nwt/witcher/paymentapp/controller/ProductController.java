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

    @GetMapping("/proizvod")
    public List<Product> get() {
        return productService.get();
    }

    @PostMapping("/proizvod")
    public Product save(@RequestBody Product productObj) {
        productService.save(productObj);
        return productObj;
    }

    @GetMapping("/proizvod/{id}")
    public Product get(@PathVariable int id) {
        Product productObj = productService.get(id);
        if (productObj == null) {
            throw new RuntimeException("Proizvod sa id-om:" + id + "nije pronađen");
        }
        return productObj;
    }

    @DeleteMapping("/proizvod/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "Proizvod je obrisan sa id-om:" + id;
    }

    @PutMapping("/proizvod")
    public Product update(@RequestBody Product productObj) {
        productService.save(productObj);
        return productObj;
    }
//	@RequestMapping(value = "/proizvod", method = RequestMethod.GET)
//	public Proizvod firstPage() {
//
//		Proizvod proizvod = new Proizvod();
//		proizvod.setCijena(10.00);
//		proizvod.setNaziv("Proizvod");
//		proizvod.setProizvodID(1);
//		proizvod.setRaspolozivaKolicina(100);
//
//		return proizvod;
//	}

}
