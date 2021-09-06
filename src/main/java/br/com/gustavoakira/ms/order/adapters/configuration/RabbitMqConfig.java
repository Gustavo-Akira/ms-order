package br.com.gustavoakira.ms.order.adapters.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.url}")
    private String url;

    @Value("${rabbitmq.product}")
    private String product;

    @Value("${rabbitmq.order}")
    private String order;

    @Bean
    public Queue queue(){
        return new Queue(order, true,false,false);
    }

    @Bean
    public Queue queue1(){
        return new Queue(product, true,false,false);
    }


    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
