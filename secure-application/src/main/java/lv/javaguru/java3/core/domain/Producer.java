package lv.javaguru.java3.core.domain;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="producers")
public class Producer {

    @Id
    @GeneratedValue(generator = "producers_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "producers_seq", sequenceName = "producers_seq", allocationSize = 1)
    @Column(name="producer_id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="producer_url", nullable = false)
    private String url;

    @Version
    @Column(name="version", nullable = false)
    private Long version;

    @Column(name="tor", nullable = false)
    @Type(type = "lv.javaguru.java3.core.utils.CustomLocalDateTime")
    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss")
    private LocalDateTime timeOfRegistration;

    @Column(name="last_update", nullable = false)
    @Type(type = "lv.javaguru.java3.core.utils.CustomLocalDateTime")
    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss")
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
