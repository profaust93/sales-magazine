package lv.javaguru.java3.core.services.product.impl;

import static lv.javaguru.java3.core.domain.ProductBuilder.createProduct;
import lv.javaguru.java3.core.database.ProductRepository;
import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.product.ProductFactory;
import lv.javaguru.java3.core.services.product.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class ProductFactoryImpl implements ProductFactory {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductValidator productValidator;


    @Override
    public Product create(String name, BigDecimal price, String productUrl) {
        productValidator.validate(name,price,productUrl);
        LocalDateTime now = LocalDateTime.now();
        Product product = createProduct()
                .withName(name)
                .withPrice(price)
                .withProductUrl(productUrl)
                .withLastUpdate(now)
                .build();
        productRepository.save(product);
        return product;
    }
}
