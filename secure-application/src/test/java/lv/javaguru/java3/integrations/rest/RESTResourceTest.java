package lv.javaguru.java3.integrations.rest;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import lv.javaguru.java3.config.SecureApplication;
import lv.javaguru.java3.integrations.rest.api.ClientResource;
import lv.javaguru.java3.integrations.rest.api.ProducerResource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@WebIntegrationTest(randomPort = true)
@SpringApplicationConfiguration(classes = {SecureApplication.class})
public class RESTResourceTest {

    @Value("${local.server.port}")
    private int port;

    protected ClientResource clientResource;

    protected ProducerResource producerResource;

    @Before
    public void init() {
        String url = "http://localhost:" + port;

        clientResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(ClientResource.class, url);

        producerResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(ProducerResource.class, url);
    }

}
