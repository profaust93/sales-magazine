package lv.javaguru.java3.core.commands.product;

import lv.javaguru.java3.core.commands.DomainCommand;

import java.math.BigDecimal;

public class CreateProductCommand implements DomainCommand<CreateProductResult> {

    private String name;
    private BigDecimal price;
    private String productUrl;

    public CreateProductCommand(String name, BigDecimal price, String productUrl) {
        this.name = name;
        this.price = price;
        this.productUrl = productUrl;
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

