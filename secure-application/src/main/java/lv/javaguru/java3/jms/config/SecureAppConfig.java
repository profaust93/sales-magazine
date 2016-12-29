package lv.javaguru.java3.jms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class SecureAppConfig {
    @Bean
    public Queue toPublicAppQueue() {
        return new Queue("toPublicAppQueue");
    }

    @Bean
    public TopicExchange toApiAppExchange(){
        return new TopicExchange("toPublicApp");
    }

    @Bean
    public Binding toApiAppBinding(){
        return BindingBuilder.bind(toPublicAppQueue()).to(toApiAppExchange()).with("*");
    }

    @Bean(name = "secureAppExecutor")
    public ExecutorService secureAppExecutor(){
        return Executors.newFixedThreadPool(10);
    }
}