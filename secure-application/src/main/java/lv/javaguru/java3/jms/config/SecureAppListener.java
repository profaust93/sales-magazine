package lv.javaguru.java3.jms.config;

import lv.javaguru.java3.core.services.product.ProductService;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class SecureAppListener {
    Logger logger = Logger.getLogger(SecureAppListener.class);

    @Autowired
    RabbitTemplate template;

    @Resource(name = "secureAppExecutor")
    ExecutorService executor;

    @Autowired
    ProductService service;

    @RabbitListener(queues = "toSecureAppQueue")
    public void onMessage(Message<String> message) {
        executor.submit(() -> {
            String correlationid = (String) message.getHeaders().get("correlationId");
//            String response = service.method((String) message.getPayload());
            String response = service.get(0l).getName();
            logger.info(response);
            Map<String, Object> header = new HashMap<>();
            header.put("correlationId", correlationid);
            Message responseMessage = new GenericMessage(response, header);
            template.convertAndSend("toApiApp", "*", responseMessage);
        });
    }
}
