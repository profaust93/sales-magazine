package lv.javaguru.java3.core.commands.product;


import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.product.ProductFactory;
import lv.javaguru.java3.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductCommandHandler implements DomainCommandHandler<CreateProductCommand, CreateProductResult> {

    @Autowired
    private ProductFactory factory;

    @Autowired
    private ProductConverter converter;


    @Override
    public CreateProductResult execute(CreateProductCommand command) {
        Product product = factory.create(
                command.getName(),
                command.getPrice(),
                command.getProductUrl(),
                command.getProducerId()
        );
        ProductDTO productDTO = converter.convert(product);
        return new CreateProductResult(productDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateProductCommand.class;
    }
}
