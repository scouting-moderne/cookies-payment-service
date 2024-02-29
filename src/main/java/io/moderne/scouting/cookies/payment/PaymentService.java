package io.moderne.scouting.cookies.payment;

import io.moderne.scouting.cookies.error.ApiError;
import io.moderne.scouting.cookies.error.ApiException;
import io.moderne.scouting.cookies.payment.order.Order;
import io.moderne.scouting.cookies.payment.order.OrderClient;
import io.moderne.scouting.cookies.payment.user.UserClient;
import io.moderne.scouting.cookies.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final UserClient userClient;
    private final OrderClient orderClient;
    private final Map<String, Payment> db = new HashMap<>();

    public Payment createPayment(String userId, String orderId) {
        User user = userClient.findUser(userId).orElseThrow(() -> new ApiException(new ApiError("User", "User not found", 500)));
        Order order = orderClient.getOrder(orderId);
        if (order.getPayedAt() != null) {
            throw new ApiException(new ApiError("Order", "Order already payed", 500));
        }
        Payment payment = new Payment(UUID.randomUUID().toString(), user, order.getPrice(), Instant.now(), null);
        db.put(payment.id(), payment);
        return payment;
    }
}
