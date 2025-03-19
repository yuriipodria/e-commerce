package pl.yuriipodria.productcatalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    private final List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public String createProduct(String name, String description) {
        UUID productId = UUID.randomUUID();

        var newProduct = new Product(
                productId,
                name,
                description
        );

        products.add(newProduct);

        return newProduct.getId();
    }

    public Product loadProductById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }

    public void changePrice(String id, BigDecimal newPrice) {
        var product = loadProductById(id);
        product.changePrice(newPrice);
    }
}
