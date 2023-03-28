package operations;

public class Minus implements Operation {
    public Minus() {
    }

    public boolean isOperationSign(char c) {
        return c == '-';
    }

    public double operate(double a, double b) {
        return a - b;
    }
}
