package com.nwt.witcher.paymentapp.controller;

import com.nwt.witcher.paymentapp.model.PaymentType;
import com.nwt.witcher.paymentapp.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping("/payment-type")
    public List<PaymentType> get() {
        return paymentTypeService.get();
    }

    @PostMapping("/payment-type")
    public PaymentType save(@RequestBody PaymentType paymentType) {
        paymentTypeService.save(paymentType);
        return paymentType;
    }

    @GetMapping("/payment-type/{id}")
    public PaymentType get(@PathVariable int id) {
        PaymentType paymentType = paymentTypeService.get(id);
        if (paymentType == null) {
            throw new RuntimeException("Naplata sa id-om:" + id + "nije pronađena");
        }
        return paymentType;
    }

    @DeleteMapping("/payment-type/{id}")
    public String delete(@PathVariable int id) {
        paymentTypeService.delete(id);
        return "Naplata je obrisana sa id-om:" + id;
    }

    @PutMapping("/payment-type")
    public PaymentType update(@RequestBody PaymentType paymentType) {
        paymentTypeService.save(paymentType);
        return paymentType;
    }
}
