package pl.yuriipodria.ecommerce.productcatalog;

import org.junit.jupiter.api.Test;
import pl.yuriipodria.ecommerce.productcatalog.ArrayListProductRepository;
import pl.yuriipodria.ecommerce.productcatalog.Product;
import pl.yuriipodria.ecommerce.productcatalog.ProductRepository;

import java.util.List;
import java.util.UUID;

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

    private ProductRepository thereIsProductRepository() {
        return new ArrayListProductRepository();
    }

    private Product thereIsProduct() {
        return new Product(UUID.randomUUID(), "fdsafds", "fas");
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
