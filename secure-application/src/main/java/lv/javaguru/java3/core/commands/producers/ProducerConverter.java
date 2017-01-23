package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.domain.Producer;
import lv.javaguru.java3.dto.ProducerDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.dto.ProducerDTOBuilder.createProducerDTO;

@Component
public class ProducerConverter {

    public ProducerDTO convert(Producer producer) {
        return createProducerDTO()
                .withId(producer.getId())
                .withName(producer.getName())
                .withUrl(producer.getUrl())
                .withTimeOfRegistration(producer.getTimeOfRegistration())
                .withLastUpdate(producer.getLastUpdate())
                .build();
    }


}
