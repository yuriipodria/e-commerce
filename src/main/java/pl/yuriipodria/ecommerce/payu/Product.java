package pl.yuriipodria.ecommerce.payu;

public class Product {
    String name;
    String unitPrice;
    String quantity;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public Product setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public Product setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }
}
