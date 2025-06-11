package pl.yuriipodria.ecommerce.payu;

public class Buyer {
    String firstName;
    String lastName;
    String email;

    public String getFirstName() {
        return firstName;
    }

    public Buyer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Buyer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Buyer setEmail(String email) {
        this.email = email;
        return this;
    }
}
