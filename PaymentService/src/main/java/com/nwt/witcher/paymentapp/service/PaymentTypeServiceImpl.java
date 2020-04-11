package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.PaymentType;
import com.nwt.witcher.paymentapp.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Transactional
    @Override
    public List<PaymentType> get() {
        return paymentTypeRepository.findAll();
    }

    @Transactional
    @Override
    public PaymentType get(int id) {
        return paymentTypeRepository.getOne(id);
    }

    @Transactional
    @Override
    public void save(PaymentType paymentType) {
        paymentTypeRepository.save(paymentType);
    }

    @Transactional
    @Override
    public void delete(int id) {
        paymentTypeRepository.deleteById(id);
    }
}
