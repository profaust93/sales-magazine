package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;

public class GetProducerResult implements DomainCommandResult {

    private ProducerDTO producer;

    public GetProducerResult(ProducerDTO producer) {
        this.producer = producer;
    }

    public ProducerDTO getProducer() {
        return producer;
    }

}
