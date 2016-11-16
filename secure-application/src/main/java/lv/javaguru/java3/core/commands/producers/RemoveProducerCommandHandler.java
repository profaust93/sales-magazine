package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.producers.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveProducerCommandHandler implements DomainCommandHandler<RemoveProducerCommand, RemoveProducerResult>{

    @Autowired
    private ProducerService producerService;

    @Override
    public RemoveProducerResult execute(RemoveProducerCommand command) {
        producerService.remove(command.getProducerId());
        return new RemoveProducerResult("Producer successfully removed");
    }

    @Override
    public Class getCommandType() {
        return RemoveProducerCommand.class;
    }
}
