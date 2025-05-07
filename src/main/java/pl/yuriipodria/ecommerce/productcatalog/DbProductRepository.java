package pl.yuriipodria.ecommerce.productcatalog;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.*;

public class DbProductRepository implements ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public DbProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> allProducts() {
        var result = jdbcTemplate.query(
                "select * from `product_catalog__products`",
                (rs, i) -> {
                    var product = new Product(
                            UUID.fromString(rs.getString("ID")),
                            rs.getString("NAME"),
                            rs.getString("DESCRIPTION")
                    );

                    return product;
                }
        );

        return result;
    }

    @Override
    public void save(Product newProduct) {
        var sql = """
                INSERT INTO `product_catalog__products` (id, name, description)
                VALUES
                    (:id, :name, :desc);
                """;

        Map<String, Object> params = new HashMap<>();
        params.put("id", newProduct.getId());
        params.put("name", newProduct.getName());
        params.put("desc", newProduct.getDescription());

        var namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedJdbcTemplate.update(sql, params);
    }

    @Override
    public Product loadProductById(String id) {
        var result = jdbcTemplate.queryForObject(
                "select * from `product_catalog__products` WHERE id = ?",
                new Object[]{id},
                (rs, i) -> {
                    var product = new Product(
                            UUID.fromString(rs.getString("ID")),
                            rs.getString("NAME"),
                            rs.getString("DESCRIPTION")
                    );

                    return  product;
                }
        );

        return result;
    }
}
