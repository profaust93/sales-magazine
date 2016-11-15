package lv.javaguru.java3.core.services.producers;


import lv.javaguru.java3.core.domain.Producer;

public interface ProducerService {

    Producer update(Long producerId,
                    String name,
                    String url);

    Producer get(Long producerId);

}
