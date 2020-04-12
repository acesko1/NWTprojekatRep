package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
