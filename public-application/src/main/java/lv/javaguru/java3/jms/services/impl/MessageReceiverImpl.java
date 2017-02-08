package lv.javaguru.java3.jms.services.impl;

import lv.javaguru.java3.jms.services.MessageReceiver;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
@Component("getProductReceiver")
public class MessageReceiverImpl implements MessageReceiver {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource(name = "receivedMessages")
    ConcurrentHashMap<String, Object> receivedMessages;

    @Override
    public Object receiveMessage(String correlationId) {
        while (true){
            if (receivedMessages.containsKey(correlationId)){
                return receivedMessages.get(correlationId);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e){
                Thread.interrupted();
            }
        }
    }
}
