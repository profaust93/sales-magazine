package lv.javaguru.java3.core.services.product.impl;

import lv.javaguru.java3.core.database.ProductDAO;
import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.product.ProductFactory;
import lv.javaguru.java3.core.services.product.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFactoryImpl implements ProductFactory {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductValidator productValidator;


    @Override
    public Product create(String name, BigDecimal price, String productUrl) {
        return null;
    }
}
