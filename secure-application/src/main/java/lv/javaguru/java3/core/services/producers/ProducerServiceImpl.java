package lv.javaguru.java3.core.services.producers;

import lv.javaguru.java3.core.database.ProducerRepository;
import lv.javaguru.java3.core.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
class ProducerServiceImpl implements ProducerService {

    @Autowired private ProducerRepository producerRepository;
    @Autowired private ProducerValidator producerValidator;
    

    @Override
    public Producer update(Long producerId, String newName, String newUrl) {
        producerValidator.validate(newName, newUrl);
        Producer producer = get(producerId);
        producer.setName(newName);
        producer.setUrl(newUrl);
        producer.setLastUpdate(LocalDateTime.now());
        return producer;
    }

    @Override
    public Producer get(Long producerId) {
        return producerRepository.findOne(producerId);
    }

    @Override
    public void remove(Long producerId) {
        Producer product = producerRepository.findOne(producerId);
        producerRepository.delete(product);
    }

}
