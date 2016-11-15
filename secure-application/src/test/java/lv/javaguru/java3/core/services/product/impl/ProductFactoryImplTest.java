package lv.javaguru.java3.core.services.product.impl;

import lv.javaguru.java3.core.database.ProductDAO;
import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.product.ProductFactory;
import lv.javaguru.java3.core.services.product.ProductValidator;
import lv.javaguru.java3.core.services.product.impl.ProductFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductFactoryImplTest {

    @Mock
    private ProductDAO productDAO;

    @Mock
    private ProductValidator productValidator;

    @InjectMocks
    private ProductFactory productFactory = new ProductFactoryImpl();

    private final static String NAME = "name";
    private final static BigDecimal PRICE = new BigDecimal(123.32);
    private final static String URL = "localhost:8080";

    @Test
    public void createShouldInvokeValidator() {
        productFactory.create(NAME, PRICE, URL);
        verify(productValidator).validate(NAME, PRICE, URL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(productValidator).validate(NAME, PRICE, URL);
        productFactory.create(NAME, PRICE, URL);
    }

    @Test
    public void createShouldPersistProductAfterValidation() {
        Product product = productFactory.create(NAME, PRICE, URL);
        InOrder inOrder = inOrder(productValidator, productDAO);
        inOrder.verify(productValidator).validate(NAME, PRICE, URL);
        inOrder.verify(productDAO).create(product);
    }

    @Test
    public void createShouldReturnNewProduct() {
        Product product = productFactory.create(NAME, PRICE, URL);
        assertThat(product.getName(), is(NAME));
        assertThat(product.getPrice(), is(PRICE));
        assertThat(product.getProductUrl(), is(URL));
    }

}
