package lv.javaguru.java3.integrations.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductDTOBuilder {

    private Long productId;
    private String name;
    private BigDecimal price;
    private String productUrl;
    private LocalDateTime lastUpdate;

    private ProductDTOBuilder() {
    }

    public static ProductDTOBuilder createProductDTO(){
        return new ProductDTOBuilder();
    }
    public ProductDTO build(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        productDTO.setPrice(price);
        productDTO.setProductUrl(productUrl);
        productDTO.setProductId(productId);
        productDTO.setLastUpdate(lastUpdate);
        return productDTO;
    }

    public ProductDTOBuilder withProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ProductDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductDTOBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductDTOBuilder withProductUrl(String productUrl) {
        this.productUrl = productUrl;
        return this;
    }

    public ProductDTOBuilder withLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
