package lv.javaguru.java3.jms.config;

import lv.javaguru.java3.dto.SalesClassifier;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class PublicAppConfig {
    @Bean
    public Queue toSecureAppQueue() {
        return new Queue("toSecureAppQueue", true, false, true);
    }

    @Bean
    public DirectExchange toSecureAppExchange() {
        return new DirectExchange("toSecureApp");
    }

    @Bean
    public Binding toSecureAppBinding() {
        return BindingBuilder.bind(toSecureAppQueue()).to(toSecureAppExchange()).with(SalesClassifier.PRODUCER.name());
    }

    @Bean
    public Binding toSecureAppBinding2() {
        return BindingBuilder.bind(toSecureAppQueue()).to(toSecureAppExchange()).with(SalesClassifier.PRODUCT.name());
    }

}
