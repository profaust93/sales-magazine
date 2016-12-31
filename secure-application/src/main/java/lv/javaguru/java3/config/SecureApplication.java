package lv.javaguru.java3.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"lv.javaguru.java3"})
@EntityScan("lv.javaguru.java3.core.domain")
@EnableJpaRepositories(basePackages = "lv.javaguru.java3.core")
@EnableTransactionManagement
public class SecureApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureApplication.class, args);
    }

}
