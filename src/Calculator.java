import java.util.Scanner;

public class Calculator {

    private double result;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        double num1 = getValidNumber(scanner, "Enter the first number: ");
        result = num1;

        while (true) {
            char operator = getValidOperator(scanner);
            if (operator == '=') {
                System.out.println("Result: " + result);
                break;
            }

            double num2 = getValidNumber(scanner, "Enter the next number: ");
            result = performOperation(result, operator, num2);
            System.out.println("Intermediate Result: " + result);
        }
    }

    private double getValidNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                scanner.nextLine();
                return number;
            } else {
                System.out.println("Error: Invalid number. Please try again.");
                scanner.nextLine();
            }
        }
    }

    private char getValidOperator(Scanner scanner) {
        while (true) {
            System.out.print("Enter an operator (+, -, *, /, %, ^) or '=' to show result: ");
            char operator = scanner.nextLine().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%' || operator == '^' || operator == '=') {
                return operator;
            } else {
                System.out.println("Error: Invalid operator. Please try again.");
            }
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
