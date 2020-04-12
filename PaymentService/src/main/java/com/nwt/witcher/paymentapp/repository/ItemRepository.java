package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> getAllByCartId(int id);
}
