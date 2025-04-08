package pl.yuriipodria.productcatalog;

import java.util.List;

public interface ProductRepository {
    List<Product> allProducts();

    void save(Product newProduct);

    Product loadProductById(String id);
}
