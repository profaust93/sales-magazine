package lv.javaguru.java3.core.database.products;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.database.ProductDAO;
import lv.javaguru.java3.core.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static lv.javaguru.java3.core.domain.ProductBuilder.createProduct;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ProductDAOImplTest extends DatabaseHibernateTest{

    private static final String NAME = "name";
    private static final String URL = "url";
    private static final BigDecimal PRICE = new BigDecimal(100.31);

    private Product product;

    @Before
    public void setUp(){
        product = createProduct()
                .withName(NAME)
                .withPrice(PRICE)
                .withProductUrl(URL)
                .build();
    }

    @Test
    @Transactional
    public void testCreateProduct() {

        assertThat(product.getId(), is(nullValue()));
        productDAO.create(product);
        assertThat(product.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        productDAO.create(product);
        Product productFromDb = productDAO.getById(product.getId());
        assertThat(productFromDb, is(notNullValue()));
    }
}
