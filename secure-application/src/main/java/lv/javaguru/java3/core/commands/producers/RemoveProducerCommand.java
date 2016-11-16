package lv.javaguru.java3.core.commands.producers;


import lv.javaguru.java3.core.commands.DomainCommand;

public class RemoveProducerCommand implements DomainCommand<RemoveProducerResult> {

    private Long producerId;

    public RemoveProducerCommand(Long producerId) {
        this.producerId = producerId;
    }

    public Long getProducerId() {
        return producerId;
    }
}
