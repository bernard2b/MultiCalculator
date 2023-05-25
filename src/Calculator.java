import java.util.Scanner;

public class Calculator {

    private double result;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        double num1;
        double num2;
        char operator;

        boolean validNum1 = false;
        do {
            System.out.print("Enter the first number: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
                result = num1; // Assign the initial number as the result
                validNum1 = true;
            } else {
                scanner.next();
                System.out.println("Error: Invalid number. Please try again.");
            }
        } while (!validNum1);

        boolean keepCalculating = true;
        while (keepCalculating) {
            boolean validOperator = false;
            do {
                System.out.print("Enter an operator (+, -, *, /, %, ^) or '=' to show result: ");
                operator = scanner.next().charAt(0);

                if (operator == '=') {
                    System.out.println("Result: " + result);
                    keepCalculating = false;
                    break;
                } else if (operator == '+' || operator == '-' || operator == '*' || operator == '/'
                        || operator == '%' || operator == '^') {
                    System.out.print("Enter the next number: ");
                    if (scanner.hasNextDouble()) {
                        num2 = scanner.nextDouble();
                        result = performOperation(result, operator, num2);
                        System.out.println("Intermediate Result: " + result);
                    } else {
                        scanner.next();
                        System.out.println("Error: Invalid number. Please try again.");
                    }
                    validOperator = true;
                } else {
                    System.out.println("Error: Invalid operator. Please try again.");
                }
            } while (!validOperator);
        }
    }

    private double performOperation(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return BasicOperators.add(num1, num2);
            case '-':
                return BasicOperators.subtract(num1, num2);
            case '*':
                return BasicOperators.multiply(num1, num2);
            case '/':
                try {
                    return BasicOperators.divide(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return num1; // Return the unchanged result in case of an exception
                }
            case '%':
                return BasicOperators.modulo(num1, num2);
            case '^':
                return BasicOperators.power(num1, num2);
            default:
                System.out.println("Error: Invalid operator");
                return num1; // Return the unchanged result for an invalid operator
        }
    }

}
