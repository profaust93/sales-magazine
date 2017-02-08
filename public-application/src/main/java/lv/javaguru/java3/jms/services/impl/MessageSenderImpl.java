package lv.javaguru.java3.jms.services.impl;


import lv.javaguru.java3.dto.ProductDTO;
import lv.javaguru.java3.dto.SalesClassifier;
import lv.javaguru.java3.dto.ServiceType;
import lv.javaguru.java3.jms.services.MessageSender;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component("getProductSender")
public class MessageSenderImpl implements MessageSender{
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    RabbitTemplate template;

    @Override
    public String sendMsg(String msg, SalesClassifier exchange, ServiceType serviceType) {
        String corrId = UUID.randomUUID().toString();
        Map<String, Object> header = new HashMap<>();
        header.put("correlationId", corrId);
        header.put("exchange", exchange);
        header.put("serviceType", serviceType);
        Message<ProductDTO> message = new GenericMessage(msg, header);
        template.convertAndSend("toSecureApp", exchange.name(), message);
        return corrId;
    }

}
