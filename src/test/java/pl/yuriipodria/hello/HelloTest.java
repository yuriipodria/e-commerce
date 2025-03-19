package pl.yuriipodria.hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloTest {

    @Test
    void myFirstTest() {
        int a = 2;
        int b = 4;

        int result = a + b;

        assert result == 6;
    }

    @Test
    void myFirstFailingTest() {
        int a = 2;
        int b = 4;

        int result = a - b;

        assert result == 6;
    }

    @Test
    void myMoreExplicitTest() {
        assertTrue(false, "Your condition does not match");
    }
}
