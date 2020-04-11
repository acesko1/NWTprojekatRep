package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> getAllByPaymentMethodId(int id);
}
