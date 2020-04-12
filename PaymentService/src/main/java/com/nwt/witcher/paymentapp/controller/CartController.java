package com.nwt.witcher.paymentapp.controller;

import com.nwt.witcher.paymentapp.model.Cart;
import com.nwt.witcher.paymentapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/payment/{id}")
    public List<Cart> getByPayment(@PathVariable int id) {
        return cartService.getByPayment(id);
    }

    @PostMapping("/cart")
    public Cart save(@RequestBody Cart cart) {
        cartService.save(cart);
        return cart;
    }

    @GetMapping("/cart/{id}")
    public Cart get(@PathVariable int id) {
        Cart cart = cartService.get(id);
        if (cart == null) {
            throw new RuntimeException("Naplata sa id-om:" + id + "nije pronađena");
        }
        return cart;
    }

    @DeleteMapping("/cart/{id}")
    public String delete(@PathVariable int id) {
        cartService.delete(id);
        return "Naplata je obrisana sa id-om:" + id;
    }

    @PutMapping("/cart")
    public Cart update(@RequestBody Cart cart) {
        cartService.save(cart);
        return cart;
    }
}
