package lv.javaguru.java3.core.services.product.impl;

import lv.javaguru.java3.core.services.product.ProductValidator;
import lv.javaguru.java3.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
public class ProductValidatorImpl implements ProductValidator{
    @Override
    public void validate(String name, BigDecimal price, String productUrl) {
        validateName(name);
        validatePrice(price);
        validateProductUrl(productUrl);
    }

    @Override
    public void validateId(Long productId, String entityName) {
        checkNotNull(productId, entityName + " id must be not null");
        checkArgument(!isNegative(productId), entityName + " id must be positive number");
    }

    @Override
    public void validate(ProductDTO productDTO) {
        checkNotNull(productDTO,"Product must be not null");
        validateName(productDTO.getName());
        validateProductUrl(productDTO.getProductUrl());
        validatePrice(productDTO.getPrice());
        validateId(productDTO.getProducerDTO().getId(), "Producer");
    }

    private void validateName(String name){
        checkNotNull(name, "Product name must not be null");
        checkArgument(!isBlank(name), "Product name must not be empty");
    }

    private void validatePrice(BigDecimal price){
        checkNotNull(price, "Product price must be not null");
        checkArgument(!isNegative(price), "Product price must be positive number");
    }

    private void validateProductUrl(String productUrl){
        //TODO validate regex
        checkNotNull(productUrl, "Product url must not be null");
        checkArgument(!isBlank(productUrl), "Product url must not be empty");
    }

    private boolean isNegative(BigDecimal number){
        return number.compareTo(new BigDecimal(0)) == -1;
    }
    private boolean isNegative(Long number){
        return number < 0;
    }

}
