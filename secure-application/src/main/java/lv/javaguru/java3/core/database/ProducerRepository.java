package lv.javaguru.java3.core.database;

import lv.javaguru.java3.core.domain.Producer;
import org.springframework.data.repository.CrudRepository;

public interface ProducerRepository extends CrudRepository<Producer, Long> {
}
