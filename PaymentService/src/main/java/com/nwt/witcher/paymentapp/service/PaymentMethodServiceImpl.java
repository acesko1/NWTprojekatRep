package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.PaymentMethod;
import com.nwt.witcher.paymentapp.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Transactional
    @Override
    public PaymentMethod get(int id) {
        return paymentMethodRepository.getOne(id);
    }

    @Transactional
    @Override
    public void save(PaymentMethod paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }

    @Transactional
    @Override
    public void delete(int id) {
        paymentMethodRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<PaymentMethod> getByType(int id) {
        return paymentMethodRepository.getAllByPaymentTypeId(id);
    }

    @Transactional
    @Override
    public List<PaymentMethod> getByUserCode(String userCode){ return paymentMethodRepository.getAllByUserCode(userCode);}
}
