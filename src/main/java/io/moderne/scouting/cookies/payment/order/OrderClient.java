package io.moderne.scouting.cookies.payment.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "order", url = "${service.order.url:http://cookies-order-service:8080}", dismiss404 = true)
public interface OrderClient {

    @GetMapping
    Order getOrder(@RequestParam String id);
}
