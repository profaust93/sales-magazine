package lv.javaguru.java3.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

public class ProducerDTO implements Serializable{

    private Long id;
    private String name;
    private String url;

    private LocalDateTime timeOfRegistration;

    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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


    @Override
    public String toString() {
        return "ProducerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", timeOfRegistration=" + timeOfRegistration +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
