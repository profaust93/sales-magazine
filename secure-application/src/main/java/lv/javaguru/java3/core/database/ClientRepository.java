package lv.javaguru.java3.core.database;

import lv.javaguru.java3.core.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {


}
