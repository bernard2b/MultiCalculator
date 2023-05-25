import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        System.out.print("Enter 1 for Regular Calculator, 2 for Converter Calculator");
        int choice = scanner.nextInt();

        if(choice == 1) {
            Calculator calculator = new Calculator();
            calculator.start();
        } else if (choice == 2) {
            ConverterCalculator converterCalculator = new ConverterCalculator();
            converterCalculator.start();
        } else {
            System.out.println("Invalid choice. Exiting the application.");
        }

    }
}

