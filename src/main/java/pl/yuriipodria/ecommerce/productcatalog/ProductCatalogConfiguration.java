package pl.yuriipodria.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.yuriipodria.ecommerce.productcatalog.SqlProductStorage;
import pl.yuriipodria.ecommerce.productcatalog.ProductCatalog;
import pl.yuriipodria.ecommerce.productcatalog.ProductStorage;

@Configuration
public class ProductCatalogConfiguration {

    @Bean
    ProductCatalog createProductCatalog(ProductStorage storage) {
        var catalog = new ProductCatalog(
                storage
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
    ProductStorage createArrayProductStorage() {
        return new ArrayListProductStorage();
    }

    @Bean
    ProductStorage createMyProductRepository(JdbcTemplate jdbcTemplate) {
        return new SqlProductStorage(jdbcTemplate);
    }
}
