package pl.yuriipodria.sales.payment;

public interface PaymentGateway {
    PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest);
}
