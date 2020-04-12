package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> get();

    Cart get(int id);

    void save(Cart cart);

    void delete(int id);

    List<Cart> getByPayment(int id);
}
