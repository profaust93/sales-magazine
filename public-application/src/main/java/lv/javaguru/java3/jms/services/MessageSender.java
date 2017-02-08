package lv.javaguru.java3.jms.services;

import lv.javaguru.java3.dto.SalesClassifier;
import lv.javaguru.java3.dto.ServiceType;

public interface MessageSender {

    String sendMsg(String msg, SalesClassifier exchange, ServiceType serviceType);
}
