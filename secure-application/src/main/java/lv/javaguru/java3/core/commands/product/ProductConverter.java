package lv.javaguru.java3.core.commands.product;

import lv.javaguru.java3.core.commands.producers.ProducerConverter;
import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.dto.ProducerDTO;
import lv.javaguru.java3.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.dto.ProductDTOBuilder.createProductDTO;

@Component
public class ProductConverter {

    @Autowired
    private ProducerConverter producerConverter;

    public ProductDTO convert(Product product){
        ProducerDTO producerDTO = producerConverter.convert(product.getProducer());
        return createProductDTO()
                .withName(product.getName())
                .withPrice(product.getPrice())
                .withProductUrl(product.getProductUrl())
                .withProductId(product.getId())
                .withLastUpdate(product.getLastUpdate())
                .withProducer(producerDTO)
                .build();
    }
}
