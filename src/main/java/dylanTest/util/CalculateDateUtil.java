package dylanTest.util;


import dylanTest.domain.DateModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CalculateDateUtil {

    public static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final Set<Integer> BIG_MONTH = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));

    /**
     * Check if given year is a leap year
     * @param year input year
     * @return if given year is a leap year
     */
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    /**
     * Count number of leap years
     * if give month is after Feb, include current year, else exclude current year
     *
     * @param dateModel give date
     * @return number of leap years
     */
     public static int countNumberOfLeapYears(DateModel dateModel) {
        int year = dateModel.getYear();

        if (dateModel.getMonth() <= 2) {
            year--;
        }
        return year / 4 - year / 100 + year / 400;
    }
}
