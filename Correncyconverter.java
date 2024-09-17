import java.util.Scanner;

public class CurrencyConverter {

    // Hardcoded exchange rates for simulation (you can replace this part with real-time API data)
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        if (baseCurrency.equalsIgnoreCase("USD") && targetCurrency.equalsIgnoreCase("INR")) {
            return 82.50; // Example exchange rate from USD to INR
        } else if (baseCurrency.equalsIgnoreCase("INR") && targetCurrency.equalsIgnoreCase("USD")) {
            return 0.012; // Example exchange rate from INR to USD
        } else if (baseCurrency.equalsIgnoreCase("EUR") && targetCurrency.equalsIgnoreCase("INR")) {
            return 90.00; // Example exchange rate from EUR to INR
        } else if (baseCurrency.equalsIgnoreCase("INR") && targetCurrency.equalsIgnoreCase("EUR")) {
            return 0.011; // Example exchange rate from INR to EUR
        } else {
            System.out.println("Currency pair not supported for now.");
            return 0;
        }
    }

    // Method to convert currency
    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Currency Selection
        System.out.print("Enter base currency (USD/INR/EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (USD/INR/EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Fetch the exchange rate for the selected currencies
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        // If exchange rate is 0, the currency pair is unsupported
        if (exchangeRate == 0) {
            System.out.println("Conversion not possible for the selected currencies.");
            return;
        }

        // Step 2: Amount Input
        System.out.print("Enter the amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        // Step 3: Currency Conversion
        double convertedAmount = convertCurrency(amount, exchangeRate);

        // Step 4: Display Result
        System.out.printf("%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);

        // Close the scanner
        scanner.close();
    }
}
