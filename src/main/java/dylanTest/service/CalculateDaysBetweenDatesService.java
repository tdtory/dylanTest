package dylanTest.service;

import dylanTest.domain.DateModel;
import dylanTest.domain.OutputModel;
import dylanTest.util.CalculateDateUtil;

/**
 * Service to calculate days between two given date
 */
public class CalculateDaysBetweenDatesService {


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
            days += CalculateDateUtil.DAYS_IN_MONTH[i];
        }

        days += CalculateDateUtil.countNumberOfLeapYears(dateModel);
        return days;
    }




}
