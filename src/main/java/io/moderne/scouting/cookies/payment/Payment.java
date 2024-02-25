package io.moderne.scouting.cookies.payment;

import io.moderne.scouting.cookies.user.User;

import java.math.BigDecimal;
import java.time.Instant;

public record Payment(String id, User user, BigDecimal price, Instant requestedAt, Instant payedAt) {
}
