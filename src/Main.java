import operations.*;
import solvers.Solver;
import validators.Validator;
import validators.ValidatorImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();

        Operation[] operations = new Operation[]{new Plus(), new Minus(), new Multiplication(), new Division()};
        Validator validator = new ValidatorImpl(operations);
        Solver solver = new Solver(operations, validator);
        Double res = solver.solve(exp);
        System.out.println(res);
    }
}
