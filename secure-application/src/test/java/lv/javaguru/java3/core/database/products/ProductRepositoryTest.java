package lv.javaguru.java3.core.database.products;

import lv.javaguru.java3.config.Application;
import lv.javaguru.java3.core.database.ProductRepository;
import lv.javaguru.java3.core.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static lv.javaguru.java3.core.domain.ProductBuilder.createProduct;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

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
        productRepository.save(product);
        assertThat(product.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        productRepository.save(product);
        Product productFromDb = productRepository.findOne(product.getId());
        assertThat(productFromDb, is(notNullValue()));
    }
}
