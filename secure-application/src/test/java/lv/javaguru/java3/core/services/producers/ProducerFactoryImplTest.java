package lv.javaguru.java3.core.services.producers;

import lv.javaguru.java3.core.database.ProducerDAO;
import lv.javaguru.java3.core.domain.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProducerFactoryImplTest {

    @Mock private ProducerValidator producerValidator;
    @Mock private ProducerDAO producerDAO;

    @InjectMocks
    private ProducerFactory producerFactory = new ProducerFactoryImpl();

    private static final String NAME = "name";
    private static final String URL = "http://sales.lv";


    @Test
    public void createShouldInvokeValidator() {
        producerFactory.create(NAME, URL);
        verify(producerValidator).validate(NAME, URL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(producerValidator).validate(NAME, URL);
        producerFactory.create(NAME, URL);
    }

    @Test
    public void createShouldPersistProducerAfterValidation() {
        Producer producer = producerFactory.create(NAME, URL);
        InOrder inOrder = inOrder(producerValidator, producerDAO);
        inOrder.verify(producerValidator).validate(NAME, URL);
        inOrder.verify(producerDAO).create(producer);
    }

    @Test
    public void createShouldReturnNewProducer() {
        Producer producer = producerFactory.create(NAME, URL);
        assertThat(producer.getName(), is(NAME));
        assertThat(producer.getUrl(), is(URL));
    }

}
