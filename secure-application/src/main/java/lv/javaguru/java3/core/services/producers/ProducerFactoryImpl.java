package lv.javaguru.java3.core.services.producers;

import lv.javaguru.java3.core.database.ProducerRepository;
import lv.javaguru.java3.core.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static lv.javaguru.java3.core.domain.ProducerBuilder.createProducer;

@Component
class ProducerFactoryImpl implements ProducerFactory {

    @Autowired private ProducerValidator producerValidator;
    @Autowired private ProducerRepository producerRepository;


    @Override
    public Producer create(String name, String url) {
        producerValidator.validate(name, url);
        LocalDateTime now = LocalDateTime.now();
        Producer producer = createProducer()
                .withName(name)
                .withUrl(url)
                .withTimeOfRegistration(now)
                .withLastUpdate(now)
                .build();
        producerRepository.save(producer);
        return producer;
    }
}
