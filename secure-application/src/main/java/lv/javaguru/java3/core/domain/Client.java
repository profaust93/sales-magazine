package lv.javaguru.java3.core.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="clients")
@Data
public class Client {

    @Id
    @GeneratedValue(generator = "clients_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "clients_seq", sequenceName = "clients_seq", allocationSize = 1)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="login", nullable = false)
    private String login;

    @Column(name="password", nullable = false)
    private String password;


}
