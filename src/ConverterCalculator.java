import java.util.InputMismatchException;
import java.util.Scanner;

class ConverterCalculator extends Calculator {

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Converter Calculator");
            System.out.printf("%-2s %-20s%n", "1.", "Pounds to Kilograms");
            System.out.printf("%-2s %-20s%n", "2.", "Kilograms to Pounds");
            System.out.printf("%-2s %-20s%n", "3.", "Grams to Ounces");
            System.out.printf("%-2s %-20s%n", "4.", "Ounces to Grams");
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
                    case 3:
                        ouncesToGrams();
                        validInput = true;
                        break;
                    case 4:
                        gramsToOunces();
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
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
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter the weight in kilograms: ");
                double kilogram = scanner.nextDouble();
                double pound = kilogram * 2.20462262;
                System.out.println("Weight in pounds: " + pound);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid weight in kilograms. ");
                scanner.nextLine();
            }
        }

    }

    public void ouncesToGrams() {

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter the weight in ounces: ");
                double ounce = scanner.nextDouble();
                double gram = ounce * 28.3495;
                System.out.println("Weight in grams: " + gram);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid weight in grams. ");
                scanner.nextLine();
            }
        }
    }

    public void gramsToOunces() {

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter the weight in grams: ");
                double gram = scanner.nextDouble();
                double ounce = gram * 0.035274;
                System.out.println("Weight in ounces: " + ounce);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid weight in ounces. ");
                scanner.nextLine();
            }
        }
    }


}
