package com.example.paymentservice.controller;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        System.out.println(LocalDate.now() + ": doPayment");
        return service.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
        System.out.println("findPaymentHistoryByOrderId: " + orderId);
        return service.findPaymentHistoryByOrderId(orderId);
    }

}
