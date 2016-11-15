package lv.javaguru.java3.core.commands.product;

import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.integrations.rest.dto.ProductDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.integrations.rest.dto.ProductDTOBuilder.createProductDTO;

@Component
public class ProductConverter {

    public ProductDTO convert(Product product){
        return createProductDTO()
                .withName(product.getName())
                .withPrice(product.getPrice())
                .withProductUrl(product.getProductUrl())
                .withProductId(product.getId())
                .withLastUpdate(product.getLastUpdate())
                .build();
    }
}
