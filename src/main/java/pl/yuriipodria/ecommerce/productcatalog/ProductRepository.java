package pl.yuriipodria.ecommerce.productcatalog;

import java.util.List;

public interface ProductRepository {
    List<Product> allProducts();

    void save(Product newProduct);

    Product loadProductById(String id);
}
