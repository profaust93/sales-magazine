package lv.javaguru.java3.jms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class PublicAppConfig {

    @Primary
    @Bean(name = "publicAppExecutor")
    public ExecutorService apiAppExecutor() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean(name = "receivedMessages")
    public ConcurrentHashMap<String, Object> receivedMessages(){
        return new ConcurrentHashMap<>();
    }
}
