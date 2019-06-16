package dylanTest.service;

import dylanTest.domain.DateModel;
import dylanTest.domain.OutputModel;

/**
 * Service to calculate days between two given date
 */
public class CalculateDaysBetweenDatesService {

    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Calculate days between two given date
     * @param firstDate the first given date
     * @param secondDate the second given date
     * @return output model
     */
    public OutputModel calculateDaysBetweenTwoDates(DateModel firstDate, DateModel secondDate) {
        int daysForFirstDate = calculateDaysBeforeDate(firstDate);
        int daysForSecondDate = calculateDaysBeforeDate(secondDate);
        OutputModel outputModel = new OutputModel();

        if (daysForFirstDate < daysForSecondDate) {
            outputModel.setDateBefore(firstDate);
            outputModel.setDateAfter(secondDate);
        } else {
            outputModel.setDateBefore(secondDate);
            outputModel.setDateAfter(firstDate);
        }
        outputModel.setNumberOfDifferenceDay(Math.abs(daysForFirstDate - daysForSecondDate));
        return outputModel;
    }


    /**
     * Calculate days before give date from 00/00/0000
     *
     * @param dateModel given date
     * @return days before given date
     */
    private int calculateDaysBeforeDate(DateModel dateModel) {

        int days = dateModel.getYear() * 365 + dateModel.getDay();

        for (int i = 0; i < dateModel.getMonth() - 1; i++) {
            days += DAYS_IN_MONTH[i];
        }

        days += countNumberOfLeapYears(dateModel);
        return days;
    }

    /**
     * Count number of leap years
     * if give month is after Feb, include current year, else exclude current year
     *
     * @param dateModel give date
     * @return number of leap years
     */
    private int countNumberOfLeapYears(DateModel dateModel) {
        int year = dateModel.getYear();

        if (dateModel.getMonth() <= 2) {
            year--;
        }
        return year / 4 - year / 100 + year / 400;
    }


}
