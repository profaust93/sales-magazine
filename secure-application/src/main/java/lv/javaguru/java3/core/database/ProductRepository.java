package lv.javaguru.java3.core.database;

import lv.javaguru.java3.core.domain.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
}
