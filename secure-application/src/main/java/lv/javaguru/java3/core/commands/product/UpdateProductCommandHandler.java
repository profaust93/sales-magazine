package lv.javaguru.java3.core.commands.product;


import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.product.ProductService;
import lv.javaguru.java3.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductCommandHandler implements DomainCommandHandler<UpdateProductCommand, UpdateProductResult>{


    @Autowired
    private ProductService service;

    @Autowired
    private ProductConverter converter;

    @Override
    public UpdateProductResult execute(UpdateProductCommand command) {
        Product product = service.update(command.getProductId(),
                                        command.getName(),
                                        command.getPrice(),
                                        command.getProductUrl());
        ProductDTO productDTO = converter.convert(product);
        return new UpdateProductResult(productDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdateProductCommand.class;
    }
}
