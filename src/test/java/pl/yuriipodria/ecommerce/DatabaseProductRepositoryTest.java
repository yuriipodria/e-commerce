package pl.yuriipodria.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.yuriipodria.ecommerce.productcatalog.ArrayListProductRepository;
import pl.yuriipodria.ecommerce.productcatalog.Product;
import pl.yuriipodria.ecommerce.productcatalog.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;

@SpringBootTest
public class DatabaseProductRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void itQueryDatabase() {
        var sql = "select now () curr_time";
        var result = jdbcTemplate.queryForObject(sql, String.class);

        assert result.contains("2025");
    }

    @Test
    void itStoresAndLoadsProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsRepository();

        repository.save(product);

        Product loaded = repository.loadProductById(product.getId());

        assertEquals(product.getId(), loaded.getId());
    }

    private ProductRepository thereIsRepository() {
        return new ArrayListProductRepository();
    }

    private Product thereIsProduct() {
        return new Product(UUID.randomUUID(), "dfsh", "fdhg");
    }


}
