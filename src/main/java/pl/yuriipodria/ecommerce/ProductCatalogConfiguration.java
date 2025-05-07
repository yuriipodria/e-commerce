package pl.yuriipodria.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.yuriipodria.ecommerce.productcatalog.DbProductRepository;
import pl.yuriipodria.ecommerce.productcatalog.ProductCatalog;
import pl.yuriipodria.ecommerce.productcatalog.ProductRepository;

@Configuration
public class ProductCatalogConfiguration {
    @Bean
    ProductCatalog createProductCatalog(ProductRepository repository) {
        var catalog = new ProductCatalog(
                repository
        );

        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");

        return catalog;
    }

    @Bean
    ProductRepository createMyProductRepository(JdbcTemplate jdbcTemplate) {
        return new DbProductRepository(jdbcTemplate);
    }
}
