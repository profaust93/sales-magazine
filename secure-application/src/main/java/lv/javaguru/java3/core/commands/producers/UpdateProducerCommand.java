package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.commands.DomainCommand;
import java.time.LocalDateTime;

public class UpdateProducerCommand implements DomainCommand<UpdateProducerResult> {

    private Long producerId;

    private String name;
    private String url;
    private LocalDateTime timeOfRegistration;
    private LocalDateTime lastUpdate;

    public UpdateProducerCommand(Long producerId,
                                 String name,
                                 String url,
                                 LocalDateTime timeOfRegistration,
                                 LocalDateTime lastUpdate) {
        this.producerId = producerId;
        this.name = name;
        this.url = url;
        this.timeOfRegistration = timeOfRegistration;
        this.lastUpdate = lastUpdate;
    }


    public Long getProducerId() {
        return producerId;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getTimeOfRegistration() {
        return timeOfRegistration;
    }

    public void setTimeOfRegistration(LocalDateTime timeOfRegistration) {
        this.timeOfRegistration = timeOfRegistration;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
