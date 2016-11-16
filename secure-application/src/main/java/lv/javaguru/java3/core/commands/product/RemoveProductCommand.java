package lv.javaguru.java3.core.commands.product;


import lv.javaguru.java3.core.commands.DomainCommand;

public class RemoveProductCommand implements DomainCommand<RemoveProductResult> {

    private Long productId;

    public RemoveProductCommand(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
