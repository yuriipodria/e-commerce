package pl.yuriipodria.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.yuriipodria.productcatalog.ArrayListProductRepository;
import pl.yuriipodria.productcatalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("dsagfsdag");
        SpringApplication.run(App.class, args);
    }

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
