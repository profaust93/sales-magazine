package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;

public class UpdateProducerResult implements DomainCommandResult {

    private ProducerDTO producer;

    public UpdateProducerResult(ProducerDTO producer) {
        this.producer = producer;
    }

    public ProducerDTO getProducerDTO() {
        return producer;
    }

}
