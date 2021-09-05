package br.com.gustavoakira.ms.order.adapters.outbound.persistence.producer;

import br.com.gustavoakira.ms.core.events.OrderMessage;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {
    private final Queue queue;

    @Autowired
    public OrderProducer(Queue queue1,RabbitTemplate template){
        queue = queue1;
        this.template = template;
    }

    private final RabbitTemplate template;

    public void send(OrderMessage message){
        this.template.convertAndSend(queue.getName(),message);
        System.out.println("message : "+message +" sended");
    }

}
