import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1;
        double num2;
        char operator;
        double result = 0.0;

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
                } else if (operator == '+' || operator == '-' || operator == '*' || operator == '/' ||
                        operator == '%' || operator == '^') {
                    System.out.print("Enter the next number: ");
                    if (scanner.hasNextDouble()) {
                        num2 = scanner.nextDouble();
                        switch (operator) {
                            case '+':
                                result = BasicOperators.add(result, num2);
                                break;
                            case '-':
                                result = BasicOperators.subtract(result, num2);
                                break;
                            case '*':
                                result = BasicOperators.multiply(result, num2);
                                break;
                            case '/':
                                try {
                                    result = BasicOperators.divide(result, num2);
                                } catch (ArithmeticException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case '%':
                                result = BasicOperators.modulo(result, num2);
                                break;
                            case '^':
                                result = BasicOperators.power(result, num2);
                                break;
                            default:
                                System.out.println("Error: Invalid operator");
                                break;
                        }
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
}

