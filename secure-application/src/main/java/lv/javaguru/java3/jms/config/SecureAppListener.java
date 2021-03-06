package lv.javaguru.java3.jms.config;

import lv.javaguru.java3.core.commands.producers.ProducerConverter;
import lv.javaguru.java3.core.commands.product.ProductConverter;
import lv.javaguru.java3.core.domain.Producer;
import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.producers.ProducerService;
import lv.javaguru.java3.core.services.product.ProductService;
import lv.javaguru.java3.dto.SalesClassifier;
import lv.javaguru.java3.dto.ServiceType;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class SecureAppListener {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    RabbitTemplate template;

    @Resource(name = "secureAppExecutor")
    ExecutorService executor;

    @Autowired
    ProductConverter productConverter;

    @Autowired
    ProductService productService;

    @Autowired
    ProducerConverter producerConverter;

    @Autowired
    ProducerService producerService;

    @RabbitListener(queues = "toSecureAppQueue")
    public void onMessage(Message<String> message) {
        executor.submit(() -> {
            String correlationId = (String) message.getHeaders().get("correlationId");
            SalesClassifier exchange = (SalesClassifier) message.getHeaders().get("exchange");
            ServiceType type = (ServiceType) message.getHeaders().get("serviceType");
            Object response = null;
            switch (exchange) {
                case PRODUCT:
                    switch (type){
                        case GET:
                            Product product = productService.get(Long.valueOf(message.getPayload()));
                            response = productConverter.convert(product);
                            break;
                        case GET_ALL:
                            List<Product> products = productService.getAll();
                            response = productConverter.convert(products);
                            break;
                }
                break;
                case PRODUCER:
                    switch (type){
                        case GET:
                            Producer producer = producerService.get(Long.valueOf(message.getPayload()));
                            response = producerConverter.convert(producer);
                            break;
                        case GET_ALL:
                            List<Producer> producers = producerService.getAll();
                            response = producerConverter.convert(producers);
                            break;
                    }
                    break;
            }
            Map<String, Object> header = new HashMap<>();
            header.put("correlationId", correlationId);
            Message responseMessage = new GenericMessage(response, header);
            template.convertAndSend("toPublicApp", exchange.name(), responseMessage);

        });
    }
}
