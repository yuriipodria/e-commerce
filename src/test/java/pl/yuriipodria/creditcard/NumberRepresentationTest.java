package pl.yuriipodria.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumberRepresentationTest {

    @Test
    void doubleRepresentation() {
        double a = 0.02;
        double b = 0.03;

        System.out.println("Result: ");
        System.out.println(b - a);
    }

    @Test
    void floatRepresentation() {
        float a = 0.02f;
        float b = 0.03f;

        System.out.println("Result: ");
        System.out.println(b - a);
    }

    @Test
    void BigDecimalRepresentation() {
        BigDecimal a = new BigDecimal("0.02");
        BigDecimal b = new BigDecimal("0.03");

        System.out.println("Result: ");
        System.out.println(b.subtract(a));

    }
}
