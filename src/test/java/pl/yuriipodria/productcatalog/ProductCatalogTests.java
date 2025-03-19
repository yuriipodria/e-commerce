package pl.yuriipodria.productcatalog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTests {

    @Test
    void itAllowsToListProducts() {
        ProductCatalog catalog = new ProductCatalog();
        List<Product> products = catalog.allProducts();

        assertTrue(products.isEmpty());
    }

    @Test
    void itAllowsToAddProducts() {
        ProductCatalog catalog = new ProductCatalog();
        catalog.createProduct("Lego  set 83", "nice one");
        List<Product> products = catalog.allProducts();

        assertFalse(products.isEmpty());
    }

    @Test
    void catalogIdentifiesProductsWithUniqueIds() {
        ProductCatalog catalog = new ProductCatalog();
        String productId1 = catalog.createProduct("Lego  set 885483", "nice one");
        String productId2 = catalog.createProduct("Lego  set 8883", "nice one");

        assertNotEquals(productId1, productId2);
    }

    @Test
    void itAllowsToLoadProductById() {
        ProductCatalog catalog = new ProductCatalog();
        String productId = catalog.createProduct("lego set 123", "aaa");

        Product loadedProduct = catalog.loadProductById(productId);

        assertEquals(productId, loadedProduct.getId());
        assertEquals("lego set 123", loadedProduct.getName());
        assertEquals("aaa", loadedProduct.getDescription());
    }

    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = new ProductCatalog();
        String productId = catalog.createProduct("lego set 123", "aaa");

        catalog.changePrice(productId, BigDecimal.valueOf(100.10));

        Product loadedProduct = catalog.loadProductById(productId);
        assertEquals(BigDecimal.valueOf(100.10), loadedProduct.getPrice());
    }

    @Test
    void priceCantBeLowerThanZero() {
        ProductCatalog catalog = new ProductCatalog();
        String productId = catalog.createProduct("lego set 123", "aaa");

        assertThrows(
                InvalidProductPriceException.class,
                () -> catalog.changePrice(productId, BigDecimal.valueOf(-10))
        );
    }

    @Test
    void itAllowsToChangeImage() {
        ProductCatalog catalog = new ProductCatalog();
        String productId = catalog.createProduct("lego set 123", "aaa");

        catalog.changeImage(productId, "https://placehold.co/600x400");

        Product loadedProduct = catalog.loadProductById(productId);
        assertEquals("https://placehold.co/600x400", loadedProduct.getImage());
    }
}
