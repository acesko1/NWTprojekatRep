package com.nwt.witcher.paymentapp.service;

import java.util.List;
import com.nwt.witcher.paymentapp.model.Payment;

public interface PaymentService {
	
	List<Payment> get();
	Payment get(int id);
	void save(Payment payment);
	void delete(int id);

    List<Payment> getByMethod(int id);
}
