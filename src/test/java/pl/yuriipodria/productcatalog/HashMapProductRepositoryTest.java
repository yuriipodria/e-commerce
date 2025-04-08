package pl.yuriipodria.productcatalog;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapProductRepositoryTest {
    @Test
    void isStoreAndLoadsProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);
        Product loaded = repository.loadProductById(product.getId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getDescription(), loaded.getDescription());
    }

    @Test
    void loadsAllProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);
        List<Product> loaded = repository.allProducts();
        assertEquals(1, loaded.size());
    }
}
