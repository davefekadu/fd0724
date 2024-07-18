package test.java.com.demo.toolrental;
import main.java.com.demo.toolrental.RentalAgreement;
import main.java.com.demo.toolrental.Tool;
import main.java.com.demo.toolrental.ToolFactory;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RentalAgreementTest {

    @Test
    public void testInvalidDiscount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Tool tool = ToolFactory.createTool("JAKR", "Ridgid");
            new RentalAgreement(tool, 5, LocalDate.of(2015, 9, 3), 101);
        });
        assertEquals("Discount percent must be between 0 and 100", exception.getMessage());
    }

    @Test
    public void testLadder() {
        Tool tool = ToolFactory.createTool("LADW", "Werner");
        RentalAgreement rentalAgreement = new RentalAgreement(tool, 3, LocalDate.of(2020, 7, 2), 10);

        System.out.println("Rental Days: " + rentalAgreement.getRentalDays());
        System.out.println("Due Date: " + rentalAgreement.getDueDate());
        System.out.println("Charge Days: " + rentalAgreement.getChargeDays());
        System.out.println("Pre-discount Charge: " + rentalAgreement.getPreDiscountCharge());
        System.out.println("Discount Amount: " + rentalAgreement.getDiscountAmount());
        System.out.println("Final Charge: " + rentalAgreement.getFinalCharge());

        assertEquals(3, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2020, 7, 4), rentalAgreement.getDueDate());
        assertEquals(2, rentalAgreement.getChargeDays());
        assertEquals(3.98, rentalAgreement.getPreDiscountCharge(), 0.01);
        assertEquals(0.40, rentalAgreement.getDiscountAmount(), 0.01);
        assertEquals(3.58, rentalAgreement.getFinalCharge(), 0.01);
    }

    @Test
    public void testChainsaw() {
        Tool tool = ToolFactory.createTool("CHNS", "Stihl");
        RentalAgreement rentalAgreement = new RentalAgreement(tool, 5, LocalDate.of(2015, 7, 2), 25);

        System.out.println("Rental Days: " + rentalAgreement.getRentalDays());
        System.out.println("Due Date: " + rentalAgreement.getDueDate());
        System.out.println("Charge Days: " + rentalAgreement.getChargeDays());
        System.out.println("Pre-discount Charge: " + rentalAgreement.getPreDiscountCharge());
        System.out.println("Discount Amount: " + rentalAgreement.getDiscountAmount());
        System.out.println("Final Charge: " + rentalAgreement.getFinalCharge());

        assertEquals(5, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2015, 7, 6), rentalAgreement.getDueDate());
        assertEquals(3, rentalAgreement.getChargeDays());
        assertEquals(4.47, rentalAgreement.getPreDiscountCharge(), 0.01);
        assertEquals(1.12, rentalAgreement.getDiscountAmount(), 0.01);
        assertEquals(3.35, rentalAgreement.getFinalCharge(), 0.01);
    }

    @Test
    public void testJackhammerWithoutDiscount() {
        Tool tool = ToolFactory.createTool("JAKD", "DeWalt");
        RentalAgreement rentalAgreement = new RentalAgreement(tool, 6, LocalDate.of(2015, 9, 3), 0);

        System.out.println("Rental Days: " + rentalAgreement.getRentalDays());
        System.out.println("Due Date: " + rentalAgreement.getDueDate());
        System.out.println("Charge Days: " + rentalAgreement.getChargeDays());
        System.out.println("Pre-discount Charge: " + rentalAgreement.getPreDiscountCharge());
        System.out.println("Discount Amount: " + rentalAgreement.getDiscountAmount());
        System.out.println("Final Charge: " + rentalAgreement.getFinalCharge());

        assertEquals(6, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2015, 9, 8), rentalAgreement.getDueDate());
        assertEquals(3, rentalAgreement.getChargeDays());
        assertEquals(8.97, rentalAgreement.getPreDiscountCharge(), 0.01);
        assertEquals(0.00, rentalAgreement.getDiscountAmount(), 0.01);
        assertEquals(8.97, rentalAgreement.getFinalCharge(), 0.01);
    }

    @Test
    public void testJackhammerWithIndependenceDay() {
        Tool tool = ToolFactory.createTool("JAKR", "Ridgid");
        RentalAgreement rentalAgreement = new RentalAgreement(tool, 9, LocalDate.of(2015, 7, 2), 0);

        System.out.println("Rental Days: " + rentalAgreement.getRentalDays());
        System.out.println("Due Date: " + rentalAgreement.getDueDate());
        System.out.println("Charge Days: " + rentalAgreement.getChargeDays());
        System.out.println("Pre-discount Charge: " + rentalAgreement.getPreDiscountCharge());
        System.out.println("Discount Amount: " + rentalAgreement.getDiscountAmount());
        System.out.println("Final Charge: " + rentalAgreement.getFinalCharge());

        assertEquals(9, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2015, 7, 10), rentalAgreement.getDueDate());
        assertEquals(6, rentalAgreement.getChargeDays());
        assertEquals(17.94, rentalAgreement.getPreDiscountCharge(), 0.01);
        assertEquals(0.00, rentalAgreement.getDiscountAmount(), 0.01);
        assertEquals(17.94, rentalAgreement.getFinalCharge(), 0.01);
    }

    @Test
    public void testJackhammerWithDiscount() {
        Tool tool = ToolFactory.createTool("JAKR", "Ridgid");
        RentalAgreement rentalAgreement = new RentalAgreement(tool, 4, LocalDate.of(2020, 7, 2), 50);

        System.out.println("Rental Days: " + rentalAgreement.getRentalDays());
        System.out.println("Due Date: " + rentalAgreement.getDueDate());
        System.out.println("Charge Days: " + rentalAgreement.getChargeDays());
        System.out.println("Pre-discount Charge: " + rentalAgreement.getPreDiscountCharge());
        System.out.println("Discount Amount: " + rentalAgreement.getDiscountAmount());
        System.out.println("Final Charge: " + rentalAgreement.getFinalCharge());

        assertEquals(4, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2020, 7, 5), rentalAgreement.getDueDate());  // Updated due date
        assertEquals(1, rentalAgreement.getChargeDays());  // Updated expected charge days
        assertEquals(2.99, rentalAgreement.getPreDiscountCharge(), 0.01);  // Corrected pre-discount charge
        assertEquals(1.49, rentalAgreement.getDiscountAmount(), 0.01);
        assertEquals(1.49, rentalAgreement.getFinalCharge(), 0.01);
    }
}
