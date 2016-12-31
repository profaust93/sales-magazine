package lv.javaguru.java3.core.commands.product;



import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.dto.ProductDTO;

public class UpdateProductResult implements DomainCommandResult{

    private ProductDTO productDTO;

    public UpdateProductResult(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }
}
