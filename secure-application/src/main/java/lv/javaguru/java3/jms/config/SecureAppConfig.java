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
    public Binding toPublicAppBindingProducer(){
        return BindingBuilder.bind(toPublicAppQueue()).to(toApiAppExchange()).with(SalesClassifier.PRODUCER.name());
    }
    @Bean
    public Binding toPublicAppBindingProduct(){
        return BindingBuilder.bind(toPublicAppQueue()).to(toApiAppExchange()).with(SalesClassifier.PRODUCT.name());
    }

    @Bean(name = "secureAppExecutor")
    public ExecutorService secureAppExecutor(){
        return Executors.newFixedThreadPool(10);
    }

    @Bean
    public Queue toSecureAppQueue() {
        return new Queue("toSecureAppQueue", true, false, true);
    }

    @Bean
    public DirectExchange toSecureAppExchange() {
        return new DirectExchange("toSecureApp");
    }

    @Bean
    public Binding toSecureAppBindingProducer() {
        return BindingBuilder.bind(toSecureAppQueue()).to(toSecureAppExchange()).with(SalesClassifier.PRODUCER.name());
    }

    @Bean
    public Binding toSecureAppBindingProduct() {
        return BindingBuilder.bind(toSecureAppQueue()).to(toSecureAppExchange()).with(SalesClassifier.PRODUCT.name());
    }
}
