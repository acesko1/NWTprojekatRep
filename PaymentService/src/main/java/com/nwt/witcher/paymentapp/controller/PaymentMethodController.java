package com.nwt.witcher.paymentapp.controller;

import com.nwt.witcher.paymentapp.model.PaymentMethod;
import com.nwt.witcher.paymentapp.service.PaymentMethodService;
import com.nwt.witcher.paymentapp.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/payment-method/type/{id}")
    public List<PaymentMethod> getByType(@PathVariable int id) {
        return paymentMethodService.getByType(id);
    }

    @PostMapping("/payment-method")
    public PaymentMethod save(@RequestBody PaymentMethod paymentMethod) {
        paymentMethodService.save(paymentMethod);
        return paymentMethod;
    }

    @GetMapping("/payment-method/{id}")
    public PaymentMethod get(@PathVariable int id) {
        PaymentMethod paymentMethod = paymentMethodService.get(id);
        if (paymentMethod == null) {
            throw new RuntimeException("Naplata sa id-om:" + id + "nije pronađena");
        }
        return paymentMethod;
    }

    @DeleteMapping("/payment-method/{id}")
    public String delete(@PathVariable int id) {
        paymentMethodService.delete(id);
        return "Naplata je obrisana sa id-om:" + id;
    }

    @PutMapping("/payment-method")
    public PaymentMethod update(@RequestBody PaymentMethod paymentMethod) {
        paymentMethodService.save(paymentMethod);
        return paymentMethod;
    }

}
