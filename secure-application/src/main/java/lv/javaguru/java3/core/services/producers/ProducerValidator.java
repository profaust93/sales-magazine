package lv.javaguru.java3.core.services.producers;


import lv.javaguru.java3.dto.ProducerDTO;

public interface ProducerValidator {

    void validate(String name, String url);

    void validate(ProducerDTO producerDTO);

}
