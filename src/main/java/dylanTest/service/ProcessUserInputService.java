package dylanTest.service;


import dylanTest.domain.DateModel;
import dylanTest.exception.IncorrectDateInputException;
import dylanTest.util.CalculateDateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Process user input.
 */
public class ProcessUserInputService {

    private static final String COMMA = ",";
    private static final String SPACE = " ";

    /**
     * Process user input, validate and generate a list that contains two dates
     *
     * @param input user input
     * @return a list contains two dates
     */
    public List<DateModel> processInput(String input) {
        String[] dateStringArray = input.split(COMMA);
        if (dateStringArray.length != 2) {
            throw new IncorrectDateInputException("Incorrect number of input date");
        }

        List<DateModel> dateModelList = Arrays.stream(dateStringArray)
                .map(mapDateStringToDateModel).collect(Collectors.toList());
        return dateModelList;
    }

    private Function<String, DateModel> mapDateStringToDateModel = (dateString) -> {
        String[] stringArray = dateString.trim().split(SPACE);
        DateModel dateModel = new DateModel();
        try {
            dateModel.setDay(new Integer(stringArray[0].trim()));
            dateModel.setMonth(new Integer(stringArray[1].trim()));
            dateModel.setYear(new Integer(stringArray[2].trim()));
        } catch (Exception e) {
            throw new IncorrectDateInputException("Incorrect input date");
        }
        if (!validateInputDate(dateModel)) {
            throw new IncorrectDateInputException("Incorrect input date");
        }
        return dateModel;
    };

    /**
     * Validate input date
     *
     * @param dateModel given date
     * @return if it is a valid date
     */
    private boolean validateInputDate(DateModel dateModel) {
        if (dateModel.getMonth() > 12 || dateModel.getDay() < 1) {
            return false;
        }
        if (dateModel.getYear() < 1900 || dateModel.getYear() > 2010) {
            return false;
        }
        if (dateModel.getDay() < 0 || dateModel.getDay() > 31) {
            return false;
        }
        if (dateModel.getMonth() == 2) {
            return dateModel.getDay() <= 28 || dateModel.getDay() <= 29 && CalculateDateUtil.isLeapYear(dateModel.getYear());
        }
        if (dateModel.getDay() == 31 && !CalculateDateUtil.BIG_MONTH.contains(dateModel.getMonth())) {
            return false;
        }
        return true;
    }


}
