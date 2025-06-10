package pl.yuriipodria.ecommerce.productcatalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProductStorage implements ProductStorage {
    private final ArrayList<Product> products;

    public ArrayListProductStorage() {
        this.products = new ArrayList<>();
    }

    @Override
    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void save(Product newProduct) {
        products.add(newProduct);
    }

    @Override
    public Product loadProductById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
}