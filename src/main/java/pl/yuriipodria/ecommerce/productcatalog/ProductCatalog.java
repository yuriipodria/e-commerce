package pl.yuriipodria.ecommerce.productcatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    private final ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts() {
        return this.productStorage.allProducts();
    }

    public String createProduct(String name, String description) {
        UUID productId = UUID.randomUUID();

        var newProduct = new Product(
                productId,
                name,
                description
        );

        productStorage.save(newProduct);

        return newProduct.getId();
    }

    public Product loadProductById(String id) {
        return productStorage.loadProductById(id);
    }

    public void changePrice(String id, BigDecimal newPrice) {
        var product = loadProductById(id);

        product.changePrice(newPrice);
    }

    public void changeImage(String id, String image) {
        var loadedProduct = this.loadProductById(id);

        loadedProduct.changeImage(image);
    }
}
