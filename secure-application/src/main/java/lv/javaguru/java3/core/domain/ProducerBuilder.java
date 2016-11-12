package lv.javaguru.java3.core.domain;

import java.time.LocalDateTime;

public class ProducerBuilder {

    private Long id;
    private String name;
    private String producerUrl;
    private LocalDateTime timeOfRegistration;
    private LocalDateTime lastUpdate;
    private Long version;

    private ProducerBuilder producerBuilder(){
        return new ProducerBuilder();
    }

    public Producer build(){
        Producer producer = new Producer();
        producer.setId(id);
        producer.setName(name);
        producer.setUrl(producerUrl);
        producer.setLastUpdate(lastUpdate);
        producer.setTimeOfRegistration(timeOfRegistration);
        producer.setVersion(version);
        return producer;
    }

    public ProducerBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProducerBuilder withName(String name) {
        this.name = name;
        return this;
    }


    public ProducerBuilder withUrl(String producerUrl) {
        this.producerUrl = producerUrl;
        return this;
    }

    public ProducerBuilder withLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public ProducerBuilder withVersion(Long version) {
        this.version = version;
        return this;
    }
}
