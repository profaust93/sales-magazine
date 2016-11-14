package lv.javaguru.java3.core.services.producers;

import lv.javaguru.java3.core.domain.Client;
import lv.javaguru.java3.core.domain.Producer;

public interface ProducerFactory {

    Producer create(String name, String url);

}
