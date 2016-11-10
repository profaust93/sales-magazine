package lv.javaguru.java3.core.services.product;

import lv.javaguru.java3.core.domain.Product;

import java.math.BigDecimal;

public interface ProductFactory {

    Product create(String name, BigDecimal price, String productUrl);

}
