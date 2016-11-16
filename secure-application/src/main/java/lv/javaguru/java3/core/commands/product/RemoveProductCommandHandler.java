package lv.javaguru.java3.core.commands.product;

import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveProductCommandHandler implements DomainCommandHandler<RemoveProductCommand, RemoveProductResult>{

    @Autowired
    private ProductService service;

    @Override
    public RemoveProductResult execute(RemoveProductCommand command) {
        service.remove(command.getProductId());
        return new RemoveProductResult("Successfully removed");
    }

    @Override
    public Class getCommandType() {
        return RemoveProductCommand.class;
    }
}
