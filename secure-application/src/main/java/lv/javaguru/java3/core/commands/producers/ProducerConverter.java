package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.domain.Producer;
import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.integrations.rest.dto.ProducerDTOBuilder.createProducerDTO;

@Component
class ProducerConverter {

    public ProducerDTO convert(Producer producer) {
        return createProducerDTO()
                .withId(producer.getId())
                .withName(producer.getName())
                .withUrl(producer.getUrl())
                .withVersion(producer.getVersion())
                .withTimeOfRegistration(producer.getTimeOfRegistration())
                .withLastUpdate(producer.getLastUpdate())
                .build();
    }


}