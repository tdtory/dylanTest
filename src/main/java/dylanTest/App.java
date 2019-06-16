/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dylanTest;

import dylanTest.domain.DateModel;
import dylanTest.domain.OutputModel;
import dylanTest.exception.IncorrectDateInputException;
import dylanTest.service.CalculateDaysBetweenDatesService;
import dylanTest.service.ProcessUserInputService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            System.out.println("Please input two dates");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            ProcessUserInputService processUserInputService = new ProcessUserInputService();
            List<DateModel> inputDateList = processUserInputService.processInput(userInput);

            CalculateDaysBetweenDatesService calculateDaysBetweenDatesService =
                    new CalculateDaysBetweenDatesService();
            OutputModel output =  calculateDaysBetweenDatesService.calculateDaysBetweenTwoDates(inputDateList.get(0),
                    inputDateList.get(1));
            System.out.println(output.generatOutputString());
        } catch (IncorrectDateInputException e) {
            System.out.println("Incorrect input date");
        }
    }
}
