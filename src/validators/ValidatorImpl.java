package validators;

import exceptions.ValidationException;
import operations.Operation;

public class ValidatorImpl implements Validator {
    private final static int THRESHOLD = 10;
    private final Operation[] operations;

    public ValidatorImpl(Operation[] operations) {
        this.operations = operations;
    }

    private boolean isOperationSign(char c) {
        for (Operation operation : operations) {
            if (operation.isOperationSign(c))
                return true;
        }
        return false;
    }

    @Override
    public void validate(String expression) throws ValidationException {
        int number = 0;
        boolean prevIsOperationSign = false;
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (isOperationSign(c)) {
                if (prevIsOperationSign || i == 0)
                    throw new ValidationException();
                number = 0;
                prevIsOperationSign = true;
            } else if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
                if (number > THRESHOLD)
                    throw new ValidationException();
                prevIsOperationSign = false;
            } else {
                throw new ValidationException();
            }
        }
        if (prevIsOperationSign)
            throw new ValidationException();
    }
}
