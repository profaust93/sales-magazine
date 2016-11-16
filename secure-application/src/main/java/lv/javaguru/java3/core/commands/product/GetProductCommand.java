package lv.javaguru.java3.core.commands.product;

import lv.javaguru.java3.core.commands.DomainCommand;

public class GetProductCommand implements DomainCommand<GetProductResult> {

    private Long productId;

    public GetProductCommand(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
