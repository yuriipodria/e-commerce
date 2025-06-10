package pl.yuriipodria.ecommerce.productcatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String id;
    private final String name;
    private final String description;
    private BigDecimal price;
    private String image;

    public Product(UUID id, String name, String description) {
        this.id = id.toString();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getImage() {
        return this.image;
    }

    public void changeImage(String image) {
        this.image = image;
    }

    public void changePrice(BigDecimal newPrice) {
        if (newPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidProductPriceException();
        }

        this.price = newPrice;
    }
}
