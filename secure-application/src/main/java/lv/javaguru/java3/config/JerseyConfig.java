package lv.javaguru.java3.config;

import lv.javaguru.java3.integrations.rest.impl.ClientResourceImpl;
import lv.javaguru.java3.integrations.rest.impl.ProducerResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ClientResourceImpl.class);
        register(ProducerResourceImpl.class);
    }

}
