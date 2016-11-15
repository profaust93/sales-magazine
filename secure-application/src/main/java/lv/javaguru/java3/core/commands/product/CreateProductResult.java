package lv.javaguru.java3.core.commands.product;


import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.integrations.rest.dto.ProductDTO;

public class CreateProductResult implements DomainCommandResult {

    private ProductDTO product;

    public CreateProductResult(ProductDTO product) {
        this.product = product;
    }

    public ProductDTO getProduct() {
        return product;
    }
}
