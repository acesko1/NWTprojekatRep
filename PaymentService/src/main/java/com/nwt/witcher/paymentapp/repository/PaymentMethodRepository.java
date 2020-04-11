package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {
    List<PaymentMethod> getAllByPaymentTypeId(int id);
}
