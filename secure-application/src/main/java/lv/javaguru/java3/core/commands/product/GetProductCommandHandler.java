package lv.javaguru.java3.core.commands.product;

import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.product.ProductService;
import lv.javaguru.java3.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetProductCommandHandler implements DomainCommandHandler<GetProductCommand, GetProductResult>{

    @Autowired
    private ProductService service;

    @Autowired
    private ProductConverter converter;

    @Override
    public GetProductResult execute(GetProductCommand command) {
        Product product = service.get(command.getProductId());
        ProductDTO productDTO = converter.convert(product);
        return new GetProductResult(productDTO);
    }

    @Override
    public Class getCommandType() {
        return GetProductCommand.class;
    }
}
