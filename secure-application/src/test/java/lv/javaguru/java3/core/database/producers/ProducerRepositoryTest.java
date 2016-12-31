package lv.javaguru.java3.core.database.producers;

import lv.javaguru.java3.config.SecureApplication;
import lv.javaguru.java3.core.database.ProducerRepository;
import lv.javaguru.java3.core.domain.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static lv.javaguru.java3.core.domain.ProducerBuilder.createProducer;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecureApplication.class)
public class ProducerRepositoryTest {

    @Autowired
    private ProducerRepository producerRepository;

    @Test
    @Transactional
    public void testCreateProducer() {
        Producer producer = createProducer()
                .withName("name")
                .withUrl("http://url.lv").build();
        assertThat(producer.getId(), is(nullValue()));
        producerRepository.save(producer);
        assertThat(producer.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetProducerById() {
        Producer producer = createProducer()
                .withName("name")
                .withUrl("http://url.lv").build();
        producerRepository.save(producer);
        Producer producerFromDb = producerRepository.findOne(producer.getId());
        assertThat(producerFromDb, is(notNullValue()));
    }

}