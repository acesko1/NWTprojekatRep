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

import com.nwt.witcher.paymentapp.model.SalesItem;
import com.nwt.witcher.paymentapp.service.SalesItemService;

@RestController
@RequestMapping("/api")
public class SalesItemController {

    @Autowired
    private SalesItemService salesItemService;

    @GetMapping("/sales-item")
    public List<SalesItem> get() {
        return salesItemService.get();
    }

    @PostMapping("/sales-item")
    public SalesItem save(@RequestBody SalesItem salesItemObj) {
        salesItemService.save(salesItemObj);
        return salesItemObj;
    }

    @GetMapping("/sales-item/{id}")
    public SalesItem get(@PathVariable int id) {
        SalesItem salesItemObj = salesItemService.get(id);
        if (salesItemObj == null) {
            throw new RuntimeException("Stavka prodaje sa id-om:" + id + "nije pronađena");
        }
        return salesItemObj;
    }

    @DeleteMapping("/sales-item/{id}")
    public String delete(@PathVariable int id) {
        salesItemService.delete(id);
        return "Stavka prodaje je obrisan sa id-om:" + id;
    }

    @PutMapping("/sales-item")
    public SalesItem update(@RequestBody SalesItem salesItemObj) {

        salesItemService.save(salesItemObj);
        return salesItemObj;
    }
}
