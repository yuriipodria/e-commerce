package pl.yuriipodria.ecommerce.payu;

public class OrderCreateResponse {
    String redirectUri;
    String orderId;

    public OrderCreateResponse setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public OrderCreateResponse setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getOrderId() {
        return orderId;
    }
}
