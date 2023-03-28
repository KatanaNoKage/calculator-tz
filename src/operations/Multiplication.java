package operations;

public class Multiplication implements Operation{
    public Multiplication(){

    }

    public boolean isOperationSign(char c) {
        return c == '*';
    }
    public double operate(double a , double b){
        return a * b;
    }
}
