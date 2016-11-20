package lv.javaguru.java3.core.domain;


import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="producers")
@Data
public class Producer {

    @Id
    @GeneratedValue(generator = "producers_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "producers_seq", sequenceName = "producers_seq", allocationSize = 1)
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

}
