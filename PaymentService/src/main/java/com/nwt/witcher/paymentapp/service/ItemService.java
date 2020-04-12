package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> get();

    Item get(int id);

    void save(Item cart);

    void delete(int id);

    List<Item> getByCart(int id);
}
