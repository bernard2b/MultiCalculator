import java.util.Scanner;

class ConverterCalculator extends Calculator {

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Converter Calculator");
        System.out.println("1. Pounds to Kilograms");
        System.out.println("2. Kilograms to Pounds");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                poundsToKilograms();
                break;
            case 2:
                kilogramsToPounds();
                break;
            default:
                System.out.println("Invalid choice. Exiting the Converter Calculator!");
        }

    }
    public void poundsToKilograms() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the weight in pounds: ");
        double pound = scanner.nextDouble();
        double kilogram = pound * 0.45359237;
        System.out.println("Weight in kilograms: " + kilogram);
    }

    public void kilogramsToPounds() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the weight in kilograms: ");
        double kilogram = scanner.nextDouble();
        double pound = kilogram * 2.20462262;
        System.out.println("Weight in pounds: " + pound);
    }


}
