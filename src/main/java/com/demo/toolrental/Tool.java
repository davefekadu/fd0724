package main.java.com.demo.toolrental;

public abstract class Tool {
    private String toolCode;
    private String brand;

    // Constructor to initialize tool code and brand
    public Tool(String toolCode, String brand) {
        this.toolCode = toolCode;
        this.brand = brand;
    }

    // Getter for tool code
    public String getToolCode() {
        return toolCode;
    }

    // Getter for brand
    public String getBrand() {
        return brand;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double getDailyCharge();
    public abstract boolean isWeekdayCharge();
    public abstract boolean isWeekendCharge();
    public abstract boolean isHolidayCharge();
}
