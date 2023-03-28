package validators;

import exceptions.ValidationException;

public interface Validator {
    void validate(String expression) throws ValidationException;
}
