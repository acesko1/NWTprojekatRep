package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.Payment;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    @Override
    public List<Payment> get() {
        return paymentRepository.findAll();
    }

    @Transactional
    @Override
    public Payment get(int id) {
        return paymentRepository.getOne(id);
    }

    @Transactional
    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Transactional
    @Override
    public void delete(int id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getByMethod(int id) {
        return paymentRepository.getAllByPaymentMethodId(id);
    }
}
