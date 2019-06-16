package dylanTest.service;

import dylanTest.domain.DateModel;
import dylanTest.domain.OutputModel;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CalculateDaysBetweenDatesServiceTest {

    private CalculateDaysBetweenDatesService testInstance;

    @Before
    public void setup() {
        testInstance = new CalculateDaysBetweenDatesService();
    }

    @Test
    @Parameters(method = "parametersToTest")
    public void shouldCalculateNumberOfDifferentDays(DateModel firstDate, DateModel secondDate, OutputModel expectOutput) {

        OutputModel actualOutput = testInstance.calculateDaysBetweenTwoDates(firstDate, secondDate);
        assertThat(convertDateModelToLocalDate(actualOutput.getDateBefore()), is(convertDateModelToLocalDate(expectOutput.getDateBefore())));
        assertThat(convertDateModelToLocalDate(actualOutput.getDateAfter()), is(convertDateModelToLocalDate(expectOutput.getDateAfter())));
        assertThat(actualOutput.getNumberOfDifferenceDay(), is(expectOutput.getNumberOfDifferenceDay()));

    }

    private Object[] parametersToTest() {
        return new Object[] {
                new Object[] {new DateModel(1995, 1, 8), new DateModel(2005, 12, 24),
                        new OutputModel(new DateModel(1995, 1, 8), new DateModel(2005, 12, 24), 4003)},
                new Object[] {new DateModel(1969, 4, 15), new DateModel(1945, 9, 12),
                        new OutputModel(new DateModel(1945, 9, 12), new DateModel(1969, 4, 15), 8616)},

                //one input year is a leap year, date is Feb 29
                new Object[] {new DateModel(1995, 1, 8), new DateModel(2000, 2, 29),
                        new OutputModel(new DateModel(1995, 1, 8), new DateModel(2000, 2, 29), 1878)},
                //one input year is a leap year, date is Feb 28
                new Object[] {new DateModel(2000, 2, 28), new DateModel(1995, 1, 8),
                        new OutputModel(new DateModel(1995, 1, 8), new DateModel(2000, 2, 28), 1877)},
                //one input year is a leap year, date is after Feb
                new Object[] {new DateModel(2000, 10, 31), new DateModel(1995, 1, 8),
                        new OutputModel(new DateModel(1995, 1, 8), new DateModel(2000, 10, 31), 2123)},
                //both years are leap years, date is Feb 29
                new Object[] {new DateModel(2000, 2, 29), new DateModel(1996, 2, 29),
                        new OutputModel(new DateModel(1996, 2, 29), new DateModel(2000, 2, 29), 1461)},
                //both years are leap years, date is random
                new Object[] {new DateModel(2000, 12, 31), new DateModel(1996, 1, 1),
                        new OutputModel(new DateModel(1996, 1, 1), new DateModel(2000, 12, 31), 1826)},
                //both date are same
                new Object[] {new DateModel(2000, 12, 31), new DateModel(2000, 12, 31),
                        new OutputModel(new DateModel(2000, 12, 31), new DateModel(2000, 12, 31), 0)},
                //min dates and max dates
                new Object[] {new DateModel(1900, 1, 1), new DateModel(2010, 12, 31),
                        new OutputModel(new DateModel(1900, 1, 1), new DateModel(2010, 12, 31), 40541)},

                //random dates
                new Object[] {new DateModel(1985, 3, 4), new DateModel(1961, 4, 12),
                        new OutputModel(new DateModel(1961, 4, 12), new DateModel(1985, 3, 4), 8727)},
                new Object[] {new DateModel(2010, 6, 10), new DateModel(2010, 6, 11),
                        new OutputModel(new DateModel(2010, 6, 10), new DateModel(2010, 6, 11), 1)},
                new Object[] {new DateModel(2008, 7, 22), new DateModel(1999, 7, 22),
                        new OutputModel(new DateModel(1999, 7, 22), new DateModel(2008, 7, 22), 3288)},

        };
    }

    private LocalDate convertDateModelToLocalDate(DateModel dateModel) {
        return LocalDate.of(dateModel.getYear(),dateModel.getMonth(), dateModel.getDay());
    }
}
