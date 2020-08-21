package com.dip.bootcamp.api.payment;

import com.dip.bootcamp.models.Payment;
import com.dip.bootcamp.models.Product;
import com.dip.bootcamp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ("/api/payment"))
public class PaymentApi {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = ("/list"))
    public List<Payment> listPayment(){
        return paymentService.getAllPayment(new Payment());
    }

}
