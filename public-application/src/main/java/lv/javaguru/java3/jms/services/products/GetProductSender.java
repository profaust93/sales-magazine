package lv.javaguru.java3.jms.services.products;


import lv.javaguru.java3.jms.services.MessageSender;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component("getProductSender")
public class GetProductSender implements MessageSender{
    Logger logger = Logger.getLogger(GetProductSender.class);

    @Autowired
    RabbitTemplate template;

    @Override
    public String sendMsg(String msg) {
        String corrId = UUID.randomUUID().toString();
        logger.info("Sending key: " + corrId);
        CorrelationData correlationData = new CorrelationData(corrId);
        Map<String, Object> header = new HashMap<>();
        header.put("correlationId", corrId);
        Message<String> message = new GenericMessage(msg, header);
        template.convertAndSend("toSecureApp", "*", message);
        return corrId;
    }

}
