package operations;

public class Division implements Operation {
    public Division() {
    }

    public boolean isOperationSign(char c) {
        return c == '/';
    }

    public double operate(double a, double b) {
        return a / b;
    }
}
