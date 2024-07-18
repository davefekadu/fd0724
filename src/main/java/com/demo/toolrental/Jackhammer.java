package main.java.com.demo.toolrental;

public class Jackhammer extends Tool {

    // Constructor to initialize tool code and brand for main.java.com.demo.toolrental.Jackhammer
    public Jackhammer(String toolCode, String brand) {
        super(toolCode, brand);
    }

    @Override
    public double getDailyCharge() {
        return 2.99;
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
        return false;
    }
}
