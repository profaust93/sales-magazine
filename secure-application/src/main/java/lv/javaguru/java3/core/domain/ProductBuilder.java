package lv.javaguru.java3.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductBuilder {

    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime lastUpdate;
    private String productUrl;
    private Long version;

    private ProductBuilder(){

    }

    public static ProductBuilder createProduct(){
        return new ProductBuilder();
    }

    public Product build(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setLastUpdate(lastUpdate);
        product.setProductUrl(productUrl);
        product.setVersion(version);
        return product;
    }

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public ProductBuilder withProductUrl(String productUrl) {
        this.productUrl = productUrl;
        return this;
    }

    public ProductBuilder withVersion(Long version) {
        this.version = version;
        return this;
    }
}
