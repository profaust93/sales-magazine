package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.dto.ProducerDTO;

public class CreateProducerResult implements DomainCommandResult {

	private ProducerDTO producer;

	public CreateProducerResult(ProducerDTO producer) {
		this.producer = producer;
	}

	public ProducerDTO getProducer() {
		return producer;
	}

}
