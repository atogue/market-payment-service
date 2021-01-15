package org.craftchain.market.payment.service;

import org.craftchain.market.payment.common.Constants;
import org.craftchain.market.payment.entity.Payment;
import org.craftchain.market.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment doPayment(Payment payment) {
        if (paymentProcessing().equalsIgnoreCase(Constants.SUCCESS.name())) {
            payment.setDate(Date.from(Instant.now())); // payment date time
            payment.setStatus(Constants.SUCCESS.toString().toLowerCase());
            payment.setTransactionId(UUID.randomUUID().toString()); // auto generated
            return  repository.save(payment);
        }
        payment.setStatus(Constants.FAILED.name());
        return payment;
    }

    public String paymentProcessing() {
        // api should be 3rd party payment gateway (paypal, visa, cb, ...)
        return new Random().nextBoolean() ? "success" : "failed";
    }
}
