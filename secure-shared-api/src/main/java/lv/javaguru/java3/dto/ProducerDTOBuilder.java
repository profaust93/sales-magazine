package lv.javaguru.java3.dto;

import java.time.LocalDateTime;

public class ProducerDTOBuilder {

    private Long id;
    private String name;
    private String producerUrl;
    private LocalDateTime timeOfRegistration;
    private LocalDateTime lastUpdate;

    private ProducerDTOBuilder producerBuilder(){
        return new ProducerDTOBuilder();
    }

    public static ProducerDTOBuilder createProducerDTO() {
        return new ProducerDTOBuilder();
    }
    
    public ProducerDTO build(){
        ProducerDTO producer = new ProducerDTO();
        producer.setId(id);
        producer.setName(name);
        producer.setUrl(producerUrl);
        producer.setLastUpdate(lastUpdate);
        producer.setTimeOfRegistration(timeOfRegistration);
        return producer;
    }

    public ProducerDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProducerDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProducerDTOBuilder withUrl(String producerUrl) {
        this.producerUrl = producerUrl;
        return this;
    }

    public ProducerDTOBuilder withTimeOfRegistration(LocalDateTime timeOfRegistration) {
        this.timeOfRegistration = timeOfRegistration;
        return this;
    }

    public ProducerDTOBuilder withLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

}
