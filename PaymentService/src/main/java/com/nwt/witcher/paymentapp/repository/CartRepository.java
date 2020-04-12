package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> getAllByPaymentId(int id);
}
