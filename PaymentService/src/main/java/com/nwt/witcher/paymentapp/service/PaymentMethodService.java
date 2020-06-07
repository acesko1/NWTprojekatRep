package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod get(int id);

    void save(PaymentMethod paymentMethod);

    void delete(int id);

    List<PaymentMethod> getByType(int id);

    List<PaymentMethod> getByUserCode(String userCode);
}
