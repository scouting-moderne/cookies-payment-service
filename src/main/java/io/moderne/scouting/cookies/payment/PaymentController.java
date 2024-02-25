package io.moderne.scouting.cookies.payment;

import io.moderne.scouting.cookies.CookieType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@RequestBody PaymentRequest request) {
        return paymentService.createPayment(request.cookies());
    }

    record PaymentRequest(Map<CookieType, Integer> cookies) {
    }
}
