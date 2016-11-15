package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.commands.DomainCommand;

public class GetProducerCommand implements DomainCommand<GetProducerResult> {

    private Long producerId;

    public GetProducerCommand(Long producerId) {
        this.producerId = producerId;
    }

    public Long getProducerId() {
        return producerId;
    }

}
