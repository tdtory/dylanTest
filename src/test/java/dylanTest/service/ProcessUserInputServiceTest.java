package dylanTest.service;


import dylanTest.domain.DateModel;
import dylanTest.exception.IncorrectDateInputException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ProcessUserInputServiceTest {

    private ProcessUserInputService testInstance;

    @Before
    public void setup() {
        testInstance = new ProcessUserInputService();
    }

    @Test(expected = IncorrectDateInputException.class)
    @Parameters(method = "parametersToTestInvalidInput")
    public void shouldThrowExceptionWhenInputIsInvalid(String inputString) {
        testInstance.processInput(inputString);
    }

    @Test
    @Parameters(method = "parametersToTestValidInput")
    public void shouldGenerateDateModelList(String inputString, DateModel firstDate, DateModel secondDate) {
       List<DateModel> list = testInstance.processInput(inputString);
       assertThat(list.size(), is(2));
       assertThat(convertDateModelToLocalDate(list.get(0)), is(convertDateModelToLocalDate(firstDate)));
       assertThat(convertDateModelToLocalDate(list.get(1)), is(convertDateModelToLocalDate(secondDate)));
    }

    private Object[] parametersToTestValidInput() {
        return new Object[] {
                new Object[] {"08 01 1995, 24 12 2005", new DateModel(1995, 1, 8),
                        new DateModel(2005, 12, 24)},
                new Object[] {"28 02 1995, 03 11 1990", new DateModel(1995, 2, 28),
                        new DateModel(1990, 11, 3)},
                new Object[] {"29 02 2000, 03 11 1990", new DateModel(2000, 2, 29),
                        new DateModel(1990, 11, 3)},
                new Object[] {"30 11 1995, 05 04 2008", new DateModel(1995, 11, 30),
                        new DateModel(2008, 4, 5)},
        };
    }

    private Object[] parametersToTestInvalidInput() {
        return new Object[] {
                new Object[] {"08 01 1995, 24 12 2005, 24 12 2005"},
                new Object[] {"08 01 1995"},

                new Object[] {"08 01 1995, 24 12 2005.2"},
                new Object[] {"08 01 1995, 24 12.0 2005"},
                new Object[] {"08 01.0 1995, 24 12.0 2005"},

                new Object[] {"08 01 test, 24 12.0 2005"},
                new Object[] {"08 01 1899, 24 12 2005"},
                new Object[] {"08 01 1990, 24 12 2011"},

                new Object[] {"30 02 1990, 24 12 2005"},
                new Object[] {"29 02 1999, 24 12 2005"},

                new Object[] {"23 03 1999, 32 12 2005"},
                new Object[] {"23 03 1999, 31 04 2005"},
                new Object[] {"23 03 1999, 31 06 2005"},
                new Object[] {"23 03 1999, 31 09 2005"},
                new Object[] {"23 03 1999, 31 11 2005"},
                new Object[] {"23 03 1999, -1 11 2005"},
                new Object[] {"23 -03 1999, -1 11 2005"},
                new Object[] {"23 03 -1999, -1 11 2005"},

                new Object[] {"23 03 abc, -1 11 2005"},
                new Object[] {"23 dc 2000, -1 11 2005"},
                new Object[] {"dfds 03 2000, -1 11 2005"},

                new Object[] {"0.31 03 2000, -1 11 2005"},
        };
    }

    private LocalDate convertDateModelToLocalDate(DateModel dateModel) {
        return LocalDate.of(dateModel.getYear(),dateModel.getMonth(), dateModel.getDay());
    }


}
