package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.domain.Producer;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.producers.ProducerFactory;
import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateProducerCommandHandler
		implements DomainCommandHandler<CreateProducerCommand, CreateProducerResult> {

	@Autowired private ProducerFactory producerFactory;
	@Autowired private ProducerConverter producerConverter;


	@Override
	public CreateProducerResult execute(CreateProducerCommand command) {
		Producer producer = producerFactory.create(
				command.getName(),
				command.getUrl()
		);
		ProducerDTO producerDTO = producerConverter.convert(producer);
		return new CreateProducerResult(producerDTO);
	}

	@Override
	public Class getCommandType() {
		return CreateProducerCommand.class;
	}
	
}
