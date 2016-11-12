package lv.javaguru.java3.core.database.producer;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.database.ProducerDAO;
import lv.javaguru.java3.core.domain.Producer;
import org.springframework.stereotype.Component;

@Component
public class ProducerDAOImpl extends CRUDOperationDAOImpl<Producer, Long> implements ProducerDAO{
}
