package lv.javaguru.java3.jms.services;

public interface MessageReceiver {

    Object receiveMessage(String correlationId);
}
