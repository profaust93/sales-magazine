package lv.javaguru.java3.core.services.product.impl;

import lv.javaguru.java3.core.database.ProductDAO;
import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.services.product.ProductService;
import lv.javaguru.java3.core.services.product.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductServiceImpl  implements ProductService{

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductValidator productValidator;

    @Override
    public Product update(Long productId, String newName, BigDecimal newPrice, String newProductUrl) {
        productValidator.validate(newName, newPrice, newProductUrl);
        productValidator.validateId(productId);
        Product product = get(productId);
        product.setName(newName);
        product.setPrice(newPrice);
        product.setProductUrl(newProductUrl);
        product.setLastUpdate(LocalDateTime.now());
        return product;
    }

    @Override
    public Product get(Long productId) {
        return productDAO.getRequired(productId);
    }

    @Override
    public void remove(Long productId) {
        Product product = productDAO.getRequired(productId);
        productDAO.delete(product);
    }
}
