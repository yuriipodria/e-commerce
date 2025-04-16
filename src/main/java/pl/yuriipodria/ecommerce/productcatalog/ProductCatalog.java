package pl.yuriipodria.ecommerce.productcatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    ProductRepository productRepository;

    public ProductCatalog(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> allProducts() {
        return this.productRepository.allProducts();
    }

    public String createProduct(String name, String description) {
        UUID productId = UUID.randomUUID();

        var newProduct = new Product(
                productId,
                name,
                description
        );

        productRepository.save(newProduct);

        return newProduct.getId();
    }

    public Product loadProductById(String id) {
        return productRepository.loadProductById(id);
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
