package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.Cart;
import com.nwt.witcher.paymentapp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    @Override
    public List<Cart> get() {
        return cartRepository.findAll();
    }

    @Transactional
    @Override
    public Cart get(int id) {
        return cartRepository.getOne(id);
    }

    @Transactional
    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Transactional
    @Override
    public void delete(int id) {
        cartRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Cart> getByPayment(int id) {
        return cartRepository.getAllByPaymentId(id);
    }
}
