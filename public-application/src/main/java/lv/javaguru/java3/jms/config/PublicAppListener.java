package lv.javaguru.java3.jms.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

@Component
@EnableRabbit
public class PublicAppListener {

    @Autowired
    RabbitTemplate template;

    @Resource(name = "publicAppExecutor")
    ExecutorService executor;

    @Resource(name = "receivedMessages")
    ConcurrentHashMap<String, Object> receivedMessages;

    @RabbitListener(queues = "toPublicAppQueue")
    public void onMessage(Message<String> message){
        String id = (String) message.getHeaders().get("correlationId");
        receivedMessages.put(id, message.getPayload());
    }
}
