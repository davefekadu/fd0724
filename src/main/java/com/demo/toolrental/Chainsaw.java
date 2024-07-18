package main.java.com.demo.toolrental;

public class Chainsaw extends Tool {

    // Constructor to initialize tool code and brand for main.java.com.demo.toolrental.Chainsaw
    public Chainsaw(String toolCode, String brand) {
        super(toolCode, brand);
    }

    @Override
    public double getDailyCharge() {
        return 1.49;
    }

    @Override
    public boolean isWeekdayCharge() {
        return true;
    }

    @Override
    public boolean isWeekendCharge() {
        return false;
    }

    @Override
    public boolean isHolidayCharge() {
        return true;
    }
}
