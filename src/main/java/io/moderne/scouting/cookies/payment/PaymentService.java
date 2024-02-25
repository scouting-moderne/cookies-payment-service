package io.moderne.scouting.cookies.payment;

import io.moderne.scouting.cookies.CookieCalculator;
import io.moderne.scouting.cookies.CookieType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService {

    public Payment createPayment(Map<CookieType, Integer> cookies) {
        BigDecimal price = CookieCalculator.calculatePrice(cookies);
        return new Payment(UUID.randomUUID().toString(), price, Instant.now(), null);
    }
}
