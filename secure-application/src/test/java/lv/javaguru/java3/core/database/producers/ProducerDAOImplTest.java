package lv.javaguru.java3.core.database.producers;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.Producer;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static lv.javaguru.java3.core.domain.ProducerBuilder.createProducer;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ProducerDAOImplTest extends DatabaseHibernateTest {

    @Test
    @Transactional
    public void testCreateProducer() {
        Producer producer = createProducer()
                .withName("name")
                .withUrl("http://url.lv").build();
        assertThat(producer.getId(), is(nullValue()));
        producerDAO.create(producer);
        assertThat(producer.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetProducerById() {
        Producer producer = createProducer()
                .withName("name")
                .withUrl("http://url.lv").build();
        producerDAO.create(producer);
        Producer producerFromDb = producerDAO.getById(producer.getId());
        assertThat(producerFromDb, is(notNullValue()));
    }

}