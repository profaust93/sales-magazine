package lv.javaguru.java3.core.services.product.impl;

import lv.javaguru.java3.core.services.product.ProductValidator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ProductValidatorImplTest {

    private ProductValidator validator = new ProductValidatorImpl();

    private static final String NAME = "name";
    private static final String URL = "url";
    private static final BigDecimal PRICE = new BigDecimal(100.31);
    private static final BigDecimal NEGATIVE_PRICE = new BigDecimal(-313.32);

    @Test
    public void validateShouldFailWhenNameIsNull() throws Exception {
        validateShouldFail(null, PRICE, URL , "Product name must not be null");
    }

    @Test
    public void validateShouldFailWhenPriceIsNull() throws Exception {
        validateShouldFail(NAME, null, URL, "Product price must be not null");
    }

    @Test
    public void validateShouldFailWhenUrlIsNull() throws Exception {
        validateShouldFail(NAME, PRICE, null, "Product url must not be null");
    }

    @Test
    public void validateShouldFailWhenNameIsBlank() throws Exception {
        validateShouldFail("",PRICE, URL, "Product name must not be empty");
    }

    @Test
    public void validateShouldFailWhenPriceIsNegative() throws Exception {
        validateShouldFail(NAME, NEGATIVE_PRICE, URL, "Product price must be positive number");
    }

    @Test
    public void validateShouldFailWhenUrlIsBlank() throws Exception {
        validateShouldFail(NAME, PRICE, "", "Product url must not be empty");
    }

    private void validateShouldFail(String name,
                                    BigDecimal price,
                                    String productUrl,
                                    String errorMessage) {
        try {
            validator.validate(name, price, productUrl);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }
}

