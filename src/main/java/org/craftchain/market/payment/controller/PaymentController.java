package org.craftchain.market.payment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.craftchain.market.payment.entity.Payment;
import org.craftchain.market.payment.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    private final PaymentService service;
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        Payment response = null;
        try {
            response = service.doPayment(payment);
        } catch (JsonProcessingException err) {
            log.error("PaymentService doPayment ERROR : ", err);
        }
        return response;
    }

    @GetMapping("{orderId}")
    public List<Payment> findPaymentHistoryByOrderId(@PathVariable int orderId) {
        List<Payment> response = null;
        try {
            response = service.findPaymentHistoryByOrderId(orderId);
        } catch (JsonProcessingException err) {
            log.error("PaymentService findPaymentHistoryByOrderId ERROR : ", err);
        }
        return response;
    }
}
