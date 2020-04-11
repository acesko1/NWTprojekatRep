package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.Item;
import com.nwt.witcher.paymentapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    @Override
    public List<Item> get() {
        return itemRepository.findAll();
    }

    @Transactional
    @Override
    public Item get(int id) {
        return itemRepository.getOne(id);
    }

    @Transactional
    @Override
    public void save(Item cart) {
        itemRepository.save(cart);
    }

    @Transactional
    @Override
    public void delete(int id) {
        itemRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Item> getByCart(int id) {
       return itemRepository.getAllByCartId(id);
    }
}
