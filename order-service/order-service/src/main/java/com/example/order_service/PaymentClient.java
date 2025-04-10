package com.example.order_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "payment-client", url = "${payment.service-url}")
public interface PaymentClient {
    @GetMapping("/payment/calculate")
    String calculate(@RequestParam("amount") double amount);
}
