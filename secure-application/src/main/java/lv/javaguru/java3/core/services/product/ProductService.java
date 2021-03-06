package lv.javaguru.java3.core.services.product;

import lv.javaguru.java3.core.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product update(Long productId, String newName, BigDecimal newPrice, String newProductUrl);

    Product get(Long productId);

    void remove(Long productId);

    List<Product> getAll();
}
