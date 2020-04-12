package com.nwt.witcher.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwt.witcher.paymentapp.model.Payment;
import com.nwt.witcher.paymentapp.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public List<Payment> get() {
        return paymentService.get();
    }

    @GetMapping("/payment/method/{id}")
    public List<Payment> getByMethod(@PathVariable int id) {
        return paymentService.getByMethod(id);
    }

    @PostMapping("/payment")
    public Payment save(@RequestBody Payment paymentObj) {
        paymentService.save(paymentObj);
        return paymentObj;
    }

    @GetMapping("/payment/{id}")
    public Payment get(@PathVariable int id) {
        Payment paymentObj = paymentService.get(id);
        if (paymentObj == null) {
            throw new RuntimeException("Naplata sa id-om:" + id + "nije pronađena");
        }
        return paymentObj;
    }

    @DeleteMapping("/payment/{id}")
    public String delete(@PathVariable int id) {
        paymentService.delete(id);
        return "Naplata je obrisana sa id-om:" + id;
    }

    @PutMapping("/payment")
    public Payment update(@RequestBody Payment paymentObj) {
        paymentService.save(paymentObj);
        return paymentObj;
    }
//	@RequestMapping(value = "/payment", method = RequestMethod.GET)
//	public Naplata firstPage() {
//
//		Naplata nap = new Naplata();
//		nap.setNaplataID(1);
//		nap.setKorisnikID(2);
//		nap.setOpis("Opis naplate");
//		nap.setStavkaProdajeID(1);
//		nap.setValuta("BAM");
//		nap.setAdresaDostave("Adresa 14");
//
//		return nap;
//	}

}
