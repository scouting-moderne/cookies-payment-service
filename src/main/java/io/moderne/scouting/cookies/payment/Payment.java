package io.moderne.scouting.cookies.payment;

import java.math.BigDecimal;
import java.time.Instant;

public record Payment(String id, BigDecimal price, Instant requestedAt, Instant payedAt) {
}
