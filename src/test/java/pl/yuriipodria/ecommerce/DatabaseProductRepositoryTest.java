package pl.yuriipodria.ecommerce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pl.yuriipodria.ecommerce.productcatalog.DbProductRepository;
import pl.yuriipodria.ecommerce.productcatalog.Product;
import pl.yuriipodria.ecommerce.productcatalog.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
public class DatabaseProductRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setupDatabase() {
        jdbcTemplate.execute("DROP TABLE `product_catalog__products` IF EXISTS");

        var sql = """
                CREATE table `product_catalog__products` (
                    id VARCHAR(100) NOT NULL,
                    name VARCHAR(50) NOT NULL,
                    description VARCHAR(144) NOT NULL,
                    cover VARCHAR(50),
                    price DECIMAL(12, 2),
                    PRIMARY KEY(id)
                );
                """;

        jdbcTemplate.execute(sql);
    }

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
        assertEquals(product.getName(), loaded.getName());
        assertEquals(product.getDescription(), loaded.getDescription());
    }

    @Test
    void initialProductTableIsEmpty() {
        var result = jdbcTemplate.queryForObject(
                "select count(*) from `product_catalog__products`",
                Integer.class
        );

        assert result == 0;
    }

    @Test
    void insertSomeProductsV1() {
        var sql = """
                INSERT INTO `product_catalog__products` (id, name, description)
                VALUES
                    ('27205e03-459e-4fa6-8a76-02b37be7106d', 'NICE PRODUCT 1', 'NICE'),
                    ('27205e03-459e-4fa6-1235e7106d', 'NICE PRODUCT 2', 'NICE'),
                    ('27205e03-459e-4fa35137be7106d', 'NICE PRODUCT 3', 'NICE');
                """;

        jdbcTemplate.execute(sql);

        var result = jdbcTemplate.queryForObject(
                "select count(*) from `product_catalog__products`",
                Integer.class
        );

        assert result == 3;
    }

    @Test
    void insertSomeProductV2DynamicValues() {
        var sql = """
                INSERT INTO `product_catalog__products` (id, name, description)
                VALUES
                    (?, ?, ?);
                """;

        jdbcTemplate.update(sql, "41256457i", "product x", "nice product x");

        var result = jdbcTemplate.queryForObject(
                "select count(*) from `product_catalog__products`",
                Integer.class
        );

        assert result == 1;
    }

    @Test
    void insertSomeProductV3DynamicValuesNamedParameters() {
        var sql = """
                INSERT INTO `product_catalog__products` (id, name, description)
                VALUES
                    (:id, :name, :desc);
                """;

        Map<String, Object> params = new HashMap<>();
        params.put("id", "fsdhkoifdhoiji");
        params.put("name", "prod y");
        params.put("desc", "nice product y");

        var namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedJdbcTemplate.update(sql, params);

        var result = jdbcTemplate.queryForObject(
                "select count(*) from `product_catalog__products`",
                Integer.class
        );

        assert result == 1;
    }

    private ProductRepository thereIsRepository() {
        return new DbProductRepository(jdbcTemplate);
    }

    private Product thereIsProduct() {
        return new Product(UUID.randomUUID(), "dfsh", "fdhg");
    }
}
