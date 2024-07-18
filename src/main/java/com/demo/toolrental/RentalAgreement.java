package main.java.com.demo.toolrental;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class RentalAgreement {
    private Tool tool;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double discountPercent;
    private double dailyCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private double discountAmount;
    private double finalCharge;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yy");
    private static final DecimalFormat CURRENCY_FORMATTER = new DecimalFormat("$#,##0.00");
    private static final DecimalFormat PERCENT_FORMATTER = new DecimalFormat("##0%");

    public RentalAgreement(Tool tool, int rentalDays, LocalDate checkoutDate, double discountPercent) {
        if (rentalDays < 1) {
            throw new IllegalArgumentException("Rental day count must be 1 or greater");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100");
        }

        this.tool = tool;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.discountPercent = discountPercent;

        this.dueDate = checkoutDate.plusDays(rentalDays - 1);
        this.dailyCharge = tool.getDailyCharge();
        this.chargeDays = calculateChargeDays();
        this.preDiscountCharge = calculatePreDiscountCharge();
        this.discountAmount = calculateDiscountAmount();
        this.finalCharge = calculateFinalCharge();
    }

    private int calculateChargeDays() {
        int chargeDays = 0;
        LocalDate currentDate = checkoutDate; // Start counting from the checkout date
        for (int i = 0; i < rentalDays; i++) {
            System.out.println("Checking date: " + currentDate);
            if (isChargeableDay(currentDate)) {
                System.out.println("Chargeable day: " + currentDate);
                chargeDays++;
            } else {
                System.out.println("Non-chargeable day: " + currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }
        return chargeDays;
    }

    private boolean isChargeableDay(LocalDate date) {
        if (date.getDayOfWeek().getValue() >= 6 && !tool.isWeekendCharge()) {
            System.out.println("Non-chargeable weekend day: " + date);
            return false;
        }
        if (HolidayManager.getInstance().isHoliday(date) && !tool.isHolidayCharge()) {
            System.out.println("Non-chargeable holiday: " + date);
            return false;
        }
        return true;
    }

    private double calculatePreDiscountCharge() {
        return chargeDays * dailyCharge;
    }

    private double calculateDiscountAmount() {
        return preDiscountCharge * (discountPercent / 100);
    }

    private double calculateFinalCharge() {
        return preDiscountCharge - discountAmount;
    }

    public void printRentalAgreement() {
        System.out.println("Tool code: " + tool.getToolCode());
        System.out.println("Tool type: " + tool.getClass().getSimpleName());
        System.out.println("Tool brand: " + tool.getBrand());
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Checkout date: " + checkoutDate.format(DATE_FORMATTER));
        System.out.println("Due date: " + dueDate.format(DATE_FORMATTER));
        System.out.println("Daily rental charge: " + CURRENCY_FORMATTER.format(dailyCharge));
        System.out.println("Charge days: " + chargeDays);
        System.out.println("Pre-discount charge: " + CURRENCY_FORMATTER.format(preDiscountCharge));
        System.out.println("Discount percent: " + PERCENT_FORMATTER.format(discountPercent / 100));
        System.out.println("Discount amount: " + CURRENCY_FORMATTER.format(discountAmount));
        System.out.println("Final charge: " + CURRENCY_FORMATTER.format(finalCharge));
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalCharge() {
        return finalCharge;
    }
}