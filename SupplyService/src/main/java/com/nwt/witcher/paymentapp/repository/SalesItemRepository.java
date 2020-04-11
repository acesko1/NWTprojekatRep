package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesItemRepository extends JpaRepository<SalesItem,Integer> {
}
