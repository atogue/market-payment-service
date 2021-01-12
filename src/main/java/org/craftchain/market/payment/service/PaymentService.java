package org.craftchain.market.payment.service;

import org.craftchain.market.payment.entity.Payment;
import org.craftchain.market.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString()); // auto generated
        return  repository.save(payment);
    }
}
