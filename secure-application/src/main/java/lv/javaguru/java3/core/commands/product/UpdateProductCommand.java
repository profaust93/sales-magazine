package lv.javaguru.java3.core.commands.product;


import lv.javaguru.java3.core.commands.DomainCommand;

import java.math.BigDecimal;

public class UpdateProductCommand implements DomainCommand<UpdateProductResult> {

    private Long productId;
    private String name;
    private BigDecimal price;
    private String productUrl;

    public UpdateProductCommand(Long productId, String name, BigDecimal price, String productUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productUrl = productUrl;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductUrl() {
        return productUrl;
    }
}
