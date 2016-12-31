package lv.javaguru.java3.core.services.product;

import lv.javaguru.java3.dto.ProductDTO;

import java.math.BigDecimal;

public interface ProductValidator {

    void validate(String name, BigDecimal price, String productUrl);

    void validateId(Long productId);

    void validate(ProductDTO productDTO);
}
