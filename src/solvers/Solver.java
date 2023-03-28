package solvers;

import operations.Operation;
import validators.Validator;

public class Solver {
    private final Operation[] operations;
    private final Validator validator;

    public Solver(Operation[] operations, Validator validator) {
        this.operations = operations;
        this.validator = validator;
    }

    private double calc(int l, int r, String expression) {
        for (Operation op : operations) {
            for (int i = l; i <= r; ++i) {
                char c = expression.charAt(i);
                if (op.isOperationSign(c)) {
                    double a = calc(l, i - 1, expression);
                    double b = calc(i + 1, r, expression);
                    return op.operate(a, b);
                }
            }
        }
        int number = 0;
        for (int i = l; i <= r; ++i) {
            number = number * 10 + (expression.charAt(i) - '0');
        }
        return number;
    }

    public double solve(String expression) {
        expression = expression.replaceAll("\\s","");
        validator.validate(expression);
        return calc(0, expression.length() - 1, expression);
    }
}
