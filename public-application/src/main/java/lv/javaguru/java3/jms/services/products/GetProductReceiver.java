package lv.javaguru.java3.jms.services.products;

import lv.javaguru.java3.jms.services.MessageReceiver;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class GetProductReceiver implements MessageReceiver {

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
