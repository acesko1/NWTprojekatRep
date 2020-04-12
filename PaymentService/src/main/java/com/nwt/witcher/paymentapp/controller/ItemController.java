package com.nwt.witcher.paymentapp.controller;

import com.nwt.witcher.paymentapp.model.Cart;
import com.nwt.witcher.paymentapp.model.Item;
import com.nwt.witcher.paymentapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item/cart/{id}")
    public List<Item> getByCart(@PathVariable int id) {
        return itemService.getByCart(id);
    }


    @PostMapping("/item")
    public Item save(@RequestBody Item item) {
        itemService.save(item);
        return item;
    }

    @GetMapping("/item/{id}")
    public Item get(@PathVariable int id) {
        Item item = itemService.get(id);
        if (item == null) {
            throw new RuntimeException("Naplata sa id-om:" + id + "nije pronađena");
        }
        return item;
    }

    @DeleteMapping("/item/{id}")
    public String delete(@PathVariable int id) {
        itemService.delete(id);
        return "Naplata je obrisana sa id-om:" + id;
    }

    @PutMapping("/item")
    public Item update(@RequestBody Item item) {
        itemService.save(item);
        return item;
    }
}
