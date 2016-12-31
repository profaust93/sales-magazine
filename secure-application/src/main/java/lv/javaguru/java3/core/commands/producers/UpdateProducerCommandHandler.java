package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.domain.Producer;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.producers.ProducerService;
import lv.javaguru.java3.dto.ProducerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UpdateProducerCommandHandler
        implements DomainCommandHandler<UpdateProducerCommand, UpdateProducerResult> {

    @Autowired private ProducerService producerService;
    @Autowired private ProducerConverter producerConverter;


    @Override
    public UpdateProducerResult execute(UpdateProducerCommand command) {
        Producer producer = producerService.update(
                command.getProducerId(),
                command.getName(),
                command.getUrl()
        );
        ProducerDTO producerDTO = producerConverter.convert(producer);
        return new UpdateProducerResult(producerDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdateProducerCommand.class;
    }

}
