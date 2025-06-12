package pl.yuriipodria.sales;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                (RegisterPaymentRequest request) -> {
                    return new PaymentDetails("http://payment");
                },
                new ReservationRepository()
        );
    }

}
