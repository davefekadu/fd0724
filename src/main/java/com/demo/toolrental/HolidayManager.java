package main.java.com.demo.toolrental;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class HolidayManager {
    private static HolidayManager instance;
    private Set<LocalDate> holidays;

    private HolidayManager() {
        holidays = new HashSet<>();
        initializeHolidays();
    }

    public static HolidayManager getInstance() {
        if (instance == null) {
            instance = new HolidayManager();
        }
        return instance;
    }

    private void initializeHolidays() {
        // Independence Day
        addHolidayForYear(2015);
        addHolidayForYear(2020);
    }

    private void addHolidayForYear(int year) {
        LocalDate independenceDay = LocalDate.of(year, Month.JULY, 4);
        switch (independenceDay.getDayOfWeek()) {
            case SATURDAY:
                holidays.add(independenceDay.minusDays(1)); // Observed on Friday
                break;
            case SUNDAY:
                holidays.add(independenceDay.plusDays(1)); // Observed on Monday
                break;
            default:
                holidays.add(independenceDay);
        }

        // Labor Day (first Monday in September)
        LocalDate laborDay = LocalDate.of(year, Month.SEPTEMBER, 1);
        while (laborDay.getDayOfWeek().getValue() != 1) {
            laborDay = laborDay.plusDays(1);
        }
        holidays.add(laborDay);
    }

    public boolean isHoliday(LocalDate date) {
        boolean isHoliday = holidays.contains(date);
        if (isHoliday) {
            System.out.println("Holiday: " + date);
        }
        return isHoliday;
    }
}
