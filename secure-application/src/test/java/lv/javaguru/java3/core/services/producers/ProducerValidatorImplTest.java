package lv.javaguru.java3.core.services.producers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ProducerValidatorImplTest {

    private ProducerValidator validator = new ProducerValidatorImpl();

    private static final String NAME = "name";
    private static final String URL = "http://sales.lv";


    @Test
    public void validateShouldFailIfNameIsNull() {
        validateShouldFail(null, URL, "Producer name must not be null");
    }


    @Test
    public void validateShouldFailIfNameIsEmpty() {
        validateShouldFail("", URL, "Producer name must not be empty");
    }


    private void validateShouldFail(String name,
                                    String url,
                                    String errorMessage) {
        try {
            validator.validate(name, url);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }

}
