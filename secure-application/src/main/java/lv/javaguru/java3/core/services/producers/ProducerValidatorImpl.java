package lv.javaguru.java3.core.services.producers;

import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
class ProducerValidatorImpl implements ProducerValidator {

    @Override
    public void validate(String name, String url) {
        validateName(name);
        //validateUrl(url);
    }

    private void validateName(String name) {
        checkNotNull(name, "Producer name must not be null");
        checkArgument(!isBlank(name), "Producer name must not be empty");
    }

    private void validateUrl(String url) {
        //TODO: check url using regex
    }
}
