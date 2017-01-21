package lv.javaguru.java3.core.services.product.impl;

import lv.javaguru.java3.core.database.ProducerRepository;
import lv.javaguru.java3.core.database.ProductRepository;
import lv.javaguru.java3.core.domain.Producer;
import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.product.ProductFactory;
import lv.javaguru.java3.core.services.product.ProductValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductFactoryImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProducerRepository producerRepository;

    @Mock
    private ProductValidator productValidator;

    @InjectMocks
    private ProductFactory productFactory = new ProductFactoryImpl();

    private final static String NAME = "name";
    private final static BigDecimal PRICE = new BigDecimal(123.32);
    private final static String URL = "localhost:8080";
    private final static Long PRODUCER_ID = new Long(0);

    private Producer producer;

    @Before
    public void setUp(){
        producer = new Producer();
        producer.setName("Apple");
        producer.setId(PRODUCER_ID);
        producer.setLastUpdate(LocalDateTime.now());
        producer.setTimeOfRegistration(LocalDateTime.now());
        producer.setUrl("URL");
    }


    @Test
    public void createShouldInvokeValidator() {
        when(producerRepository.findOne(PRODUCER_ID)).thenReturn(producer);
        productFactory.create(NAME, PRICE, URL,PRODUCER_ID);
        verify(productValidator).validate(NAME, PRICE, URL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(productValidator).validate(NAME, PRICE, URL);
        productFactory.create(NAME, PRICE, URL, PRODUCER_ID);
    }

    @Test
    public void createShouldPersistProductAfterValidation() {
        Product product = productFactory.create(NAME, PRICE, URL,PRODUCER_ID);
        InOrder inOrder = inOrder(productValidator, productRepository);
        inOrder.verify(productValidator).validate(NAME, PRICE, URL);
        inOrder.verify(productRepository).save(product);
    }

    @Test
    public void createShouldReturnNewProduct() {
        when(producerRepository.findOne(PRODUCER_ID)).thenReturn(producer);
        Product product = productFactory.create(NAME, PRICE, URL, PRODUCER_ID);
        assertThat(product.getName(), is(NAME));
        assertThat(product.getPrice(), is(PRICE));
        assertThat(product.getProductUrl(), is(URL));
        assertThat(product.getProducer(), is(producer));
    }

}
