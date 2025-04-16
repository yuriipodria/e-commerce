package pl.yuriipodria.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.yuriipodria.ecommerce.productcatalog.ArrayListProductRepository;
import pl.yuriipodria.ecommerce.productcatalog.ProductCatalog;

@Configuration
public class ProductCatalogConfiguration {
    @Bean
    ProductCatalog createProductCatalog() {
        var catalog = new ProductCatalog(
                new ArrayListProductRepository()
        );

        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");
        catalog.createProduct("aa", "saa");

        return catalog;
    }
}
