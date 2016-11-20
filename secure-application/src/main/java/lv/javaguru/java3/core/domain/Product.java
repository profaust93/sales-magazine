package lv.javaguru.java3.core.domain;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @Column(name="product_id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="price", nullable = false)
    private BigDecimal price;


    @Column(name="last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name="product_url", nullable = false)
    private String productUrl;

    @Version
    @Column(name="version", nullable = false)
    private Long version;

}
