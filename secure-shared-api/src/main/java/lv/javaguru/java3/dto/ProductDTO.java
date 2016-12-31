package lv.javaguru.java3.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDTO implements Serializable {

    private Long productId;
    private String name;
    private BigDecimal price;
    private String productUrl;
    private LocalDateTime lastUpdate;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public ProductDTO setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productUrl='" + productUrl + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
