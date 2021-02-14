package com.vinicius.springkafka.Resources;

import com.vinicius.springkafka.Producers.OrderProducer;
import com.vinicius.springkafka.Producers.OrderRecordProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ordersRecord")
@Slf4j
public class OrderRecordController {

    private final OrderRecordProducer orderProducer;

    public OrderRecordController(OrderRecordProducer orderProducer) {
        this.orderProducer = orderProducer;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody String order) {
        orderProducer.send(order);
    }
}