package main.java.com.demo.toolrental;

public class Ladder extends Tool {

    // Constructor to initialize tool code and brand for main.java.com.demo.toolrental.Ladder
    public Ladder(String toolCode, String brand) {
        super(toolCode, brand);
    }

    @Override
    public double getDailyCharge() {
        return 1.99;
    }

    @Override
    public boolean isWeekdayCharge() {
        return true;
    }

    @Override
    public boolean isWeekendCharge() {
        return true;
    }

    @Override
    public boolean isHolidayCharge() {
        return false;
    }
}
