package com.dip.bootcamp.services;

import com.dip.bootcamp.models.Payment;
import com.dip.bootcamp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    public List<Payment> getAllPayment(Payment dataParam) {
        return repository.listPayment(dataParam);
    }

}
