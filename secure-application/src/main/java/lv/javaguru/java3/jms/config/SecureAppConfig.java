package lv.javaguru.java3.jms.config;

import lv.javaguru.java3.dto.SalesClassifier;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
    public DirectExchange toApiAppExchange(){
        return new DirectExchange("toPublicApp");
    }

    @Bean
    public Binding toApiAppBinding(){
        return BindingBuilder.bind(toPublicAppQueue()).to(toApiAppExchange()).with(SalesClassifier.PRODUCER.name());
    }
    @Bean
    public Binding toApiAppBinding2(){
        return BindingBuilder.bind(toPublicAppQueue()).to(toApiAppExchange()).with(SalesClassifier.PRODUCT.name());
    }

    @Bean(name = "secureAppExecutor")
    public ExecutorService secureAppExecutor(){
        return Executors.newFixedThreadPool(10);
    }
}
