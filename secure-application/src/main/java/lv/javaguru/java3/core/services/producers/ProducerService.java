package lv.javaguru.java3.core.services.producers;


import lv.javaguru.java3.core.domain.Producer;

import java.util.List;

public interface ProducerService {

    Producer update(Long producerId,
                    String name,
                    String url);

    Producer get(Long producerId);

    void remove(Long productId);

    List<Producer> getAll();

}
