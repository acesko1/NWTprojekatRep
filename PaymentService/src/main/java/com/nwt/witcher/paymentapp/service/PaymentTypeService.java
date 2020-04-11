package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentType> get();
    PaymentType get(int id);
    void save(PaymentType paymentType);
    void delete(int id);
}
