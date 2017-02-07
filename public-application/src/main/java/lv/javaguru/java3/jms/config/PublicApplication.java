package lv.javaguru.java3.jms.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"lv.javaguru.java3"})
@EnableTransactionManagement
public class PublicApplication {

    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }


    public static void main(String[] args) {
        SpringApplication.run(PublicApplication.class, args);
    }

}
