package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.domain.Producer;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.producers.ProducerService;
import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetProducerCommandHandler
        implements DomainCommandHandler<GetProducerCommand, GetProducerResult> {

    @Autowired private ProducerService producerService;
    @Autowired private ProducerConverter producerConverter;


    @Override
    public GetProducerResult execute(GetProducerCommand command) {
        Producer producer = producerService.get(command.getProducerId());
        ProducerDTO producerDTO = producerConverter.convert(producer);
        return new GetProducerResult(producerDTO);
    }

    @Override
    public Class getCommandType() {
        return GetProducerCommand.class;
    }

}
