package com.example.payment_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestParam double amount) {
        double total = amount + 10;
        return ResponseEntity.ok("Tổng tiền: " + total);
    }
}
