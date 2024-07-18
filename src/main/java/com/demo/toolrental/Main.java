package main.java.com.demo.toolrental;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        try {
            // Prompt user for input
            System.out.print("Enter tool code: ");
            String toolCode = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter tool brand: ");
            String brand = scanner.nextLine().trim();

            System.out.print("Enter rental days: ");
            int rentalDays = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter discount percent: ");
            int discountPercent = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter checkout date (MM/dd/yyyy): ");
            String dateInput = scanner.nextLine().trim();
            LocalDate checkoutDate = LocalDate.parse(dateInput, formatter);

            // Create tool and rental agreement, then print the agreement
            Tool tool = ToolFactory.createTool(toolCode, brand);
            RentalAgreement rentalAgreement = new RentalAgreement(tool, rentalDays, checkoutDate, discountPercent);
            rentalAgreement.printRentalAgreement();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format. Please enter valid integers for rental days and discount percent.");
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format. Please enter the date in MM/dd/yyyy format.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
