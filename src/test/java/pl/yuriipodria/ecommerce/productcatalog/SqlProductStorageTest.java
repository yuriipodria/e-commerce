package pl.yuriipodria.ecommerce.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SqlProductStorageTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static final String EXAMPLE_PRODUCT_NAME = "example product";

    @Test
    void itStoresAndLoadProduct() {
        var product = thereIsProduct();
        var productStorage = thereIsProductStorage();

        productStorage.save(product);

        List<Product> products = productStorage.allProducts();

        assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains(EXAMPLE_PRODUCT_NAME);
    }

    @Test
    void itStoresAndLoadById() {
        var product = thereIsProduct();
        var productStorage = thereIsProductStorage();

        productStorage.save(product);
        var loaded = productStorage.loadProductById(product.getId());

        assertThat(loaded.getId()).isEqualTo(product.getId());
    }

    private SqlProductStorage thereIsProductStorage() {
        return new SqlProductStorage(jdbcTemplate);
    }

    private Product thereIsProduct() {
        var product = new Product(UUID.randomUUID(), EXAMPLE_PRODUCT_NAME, "nice one");
        product.changePrice(BigDecimal.valueOf(10.10));

        return product;
    }
}
