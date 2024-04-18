import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for temperature value and unit
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char unit = scanner.next().charAt(0);

        // Convert temperature based on input unit
        double convertedToFahrenheit = 0;
        double convertedToKelvin = 0;
        switch (unit) {
            case 'C':
            case 'c':
                convertedToFahrenheit = celsiusToFahrenheit(temperature);
                convertedToKelvin = celsiusToKelvin(temperature);
                break;
            case 'F':
            case 'f':
                convertedToFahrenheit = temperature;
                convertedToKelvin = fahrenheitToKelvin(temperature);
                temperature = fahrenheitToCelsius(temperature);
                break;
            case 'K':
            case 'k':
                convertedToKelvin = temperature;
                convertedToFahrenheit = kelvinToFahrenheit(temperature);
                temperature = kelvinToCelsius(temperature);
                break;
            default:
                System.out.println("Invalid unit of measurement.");
                scanner.close(); // Close scanner in case of invalid input
                return;
        }

        // Display the converted temperatures
        System.out.println("Temperature in Celsius: " + temperature);
        System.out.println("Temperature in Fahrenheit: " + convertedToFahrenheit);
        System.out.println("Temperature in Kelvin: " + convertedToKelvin);

        scanner.close(); // Close scanner after use
    }

    // Conversion functions
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin * 9 / 5) - 459.67;
    }
}
