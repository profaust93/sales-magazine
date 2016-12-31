package lv.javaguru.java3.core.services.producers;

import lv.javaguru.java3.dto.ProducerDTO;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
class ProducerValidatorImpl implements ProducerValidator {

    @Override
    public void validate(String name, String url) {
        validateName(name);
        validateUrl(url);
    }

    @Override
    public void validate(ProducerDTO producerDTO) {
        validateName(producerDTO.getName());
        validateUrl(producerDTO.getUrl());
    }

    private void validateName(String name) {
        checkNotNull(name, "Producer name must not be null");
        checkArgument(!isBlank(name), "Producer name must not be empty");
    }

    private void validateUrl(String url) {
        //TODO: check url using regex
    }
}
