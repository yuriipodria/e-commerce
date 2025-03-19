package pl.yuriipodria.hello;

public class App {
    public static void main(String[] args) {
        String name = "Yurii";

        System.out.format("Hello %s", name);

        int a = 2;
        int b = 3;

        int result = a - b;

        System.out.println("\n" + b);
        System.out.format("Result: %d", result);

        if (result != 5) {
            throw new IllegalStateException("ERROR");
        }
    }
}
