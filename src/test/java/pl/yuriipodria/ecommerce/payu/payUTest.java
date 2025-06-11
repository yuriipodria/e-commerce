package pl.yuriipodria.ecommerce.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class payUTest {
    @Test
    void itRegistersPayment() {
        PayU payU = thereIsPayU();

        OrderCreateRequest request = thereIsExampleOrderCreateRequest();
        OrderCreateResponse response = payU.handle(request);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {
        var exampleCreateRequest = new OrderCreateRequest();

        exampleCreateRequest
                .setCustomerIp("120.0.0.1")
                .setDescription("service")
                .setCurrencyCode("PLN")
                .setTotalAmount("2000000")
                .setExtOrderId(UUID.randomUUID().toString())
                .setBuyer(
                        new Buyer()
                        .setEmail("dsafgsdg")
                        .setFirstName("Joihn")
                        .setLastName("doe")
                )
                .setProducts(
                        Arrays.asList(
                            new Product()
                                    .setName("sdafa")
                                    .setUnitPrice("sdg")
                                    .setQuantity("1"),
                            new Product()
                                    .setName("sdafa")
                                    .setUnitPrice("sdg")
                                    .setQuantity("1")
                        )
                );

        return  exampleCreateRequest;
    }

    private PayU thereIsPayU() {
        var cfg = PayUConfiguration.sandbox();

        return new PayU(new RestTemplate(), cfg);
    }
}
