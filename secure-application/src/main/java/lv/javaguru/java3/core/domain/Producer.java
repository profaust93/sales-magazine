package lv.javaguru.java3.core.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="producers")
public class Producer {

    @Id
    @GeneratedValue(generator = "producers_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "producers_seq", sequenceName = "producers_seq", allocationSize = 10)
    @Column(name="producer_id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="producer_url")
    private String url;

    @Version
    @Column(name="version", nullable = false)
    private Long version;

    @Column(name="tor", nullable = false)
    private LocalDateTime timeOfRegistration;

    @Column(name="last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producer")
    private Set<Product> products = new HashSet<>(0);

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
