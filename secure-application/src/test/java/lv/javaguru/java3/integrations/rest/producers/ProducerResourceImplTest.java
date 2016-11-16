package lv.javaguru.java3.integrations.rest.producers;

import lv.javaguru.java3.integrations.rest.RESTResourceTest;
import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;

import static lv.javaguru.java3.integrations.rest.dto.ProducerDTOBuilder.createProducerDTO;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ProducerResourceImplTest extends RESTResourceTest {

    @Test
    public void createProducerTest() {
        ProducerDTO producer = producerResource.create(
                createProducerDTO()
                        .withName(RandomStringUtils.random(20))
                        .withUrl(RandomStringUtils.random(20)).build()
        );
        assertThat(producer, is(notNullValue()));
        assertThat(producer.getId(), is(notNullValue()));
    }

    @Test
    public void getProducerTest() {
        ProducerDTO newProducer = producerResource.create(
                createProducerDTO()
                        .withName(RandomStringUtils.random(20))
                        .withUrl(RandomStringUtils.random(20)).build()
        );
        ProducerDTO oldProducer = producerResource.get(newProducer.getId());
        assertThat(newProducer.getId(), is(oldProducer.getId()));
        assertThat(newProducer.getName(), is(oldProducer.getName()));
        assertThat(newProducer.getUrl(), is(oldProducer.getUrl()));
    }

}
