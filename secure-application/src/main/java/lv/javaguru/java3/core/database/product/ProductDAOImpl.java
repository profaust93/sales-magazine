package lv.javaguru.java3.core.database.product;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.database.ProductDAO;
import lv.javaguru.java3.core.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl extends CRUDOperationDAOImpl<Product, Long> implements ProductDAO{
}
