package io.moderne.scouting.cookies.payment.order;

import io.moderne.scouting.cookies.CookieType;
import io.moderne.scouting.cookies.user.User;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

@Data
public class Order {
    String id;
    User user;
    Map<CookieType, Integer> cookies;
    BigDecimal price;
    Instant createdAt;
    Instant payedAt;
    Instant deliveredAt;
}
