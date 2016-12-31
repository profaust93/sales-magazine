package lv.javaguru.java3.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lv.javaguru.java3.dto.utils.LocalDateTimeSerializer;
import lv.javaguru.java3.dto.utils.LocalDateTimeDeserializer;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ProducerDTO implements Serializable{

    private Long id;
    private String name;
    private String url;
    private Long version;


    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using= LocalDateTimeDeserializer.class)
    private LocalDateTime timeOfRegistration;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using= LocalDateTimeDeserializer.class)
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
