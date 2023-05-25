import java.util.InputMismatchException;
import java.util.Scanner;

class ConverterCalculator extends Calculator {

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Converter Calculator");
            System.out.println("1. Pounds to Kilograms");
            System.out.println("2. Kilograms to Pounds");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        poundsToKilograms();
                        validInput = true;
                        break;
                    case 2:
                        kilogramsToPounds();
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Exiting the Converter Calculator!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }

    }

    public void poundsToKilograms() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter the weight in pounds: ");
                double pound = scanner.nextDouble();
                double kilogram = pound * 0.45359237;
                System.out.println("Weight in kilograms: " + kilogram);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid weight in pounds. ");
                scanner.nextLine();
            }
        }

    }

    public void kilogramsToPounds() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the weight in kilograms: ");
        double kilogram = scanner.nextDouble();
        double pound = kilogram * 2.20462262;
        System.out.println("Weight in pounds: " + pound);
    }


}
