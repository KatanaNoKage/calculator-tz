package operations;

public class Plus implements Operation{
    public Plus(){

    }


    public boolean isOperationSign(char c) {
        return c == '+';
    }
    public double operate(double a, double b){
        return a + b;
    }
}
