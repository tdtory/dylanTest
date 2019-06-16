package dylanTest.domain;

public class OutputModel {

    private DateModel dateBefore;
    private DateModel dateAfter;
    private Integer numberOfDifferenceDay;

    public OutputModel() {
    }

    public OutputModel(DateModel dateBefore, DateModel dateAfter, Integer numberOfDifferenceDay) {
        this.dateBefore = dateBefore;
        this.dateAfter = dateAfter;
        this.numberOfDifferenceDay = numberOfDifferenceDay;
    }

    public DateModel getDateBefore() {
        return dateBefore;
    }

    public void setDateBefore(DateModel dateBefore) {
        this.dateBefore = dateBefore;
    }

    public DateModel getDateAfter() {
        return dateAfter;
    }

    public void setDateAfter(DateModel dateAfter) {
        this.dateAfter = dateAfter;
    }

    public Integer getNumberOfDifferenceDay() {
        return numberOfDifferenceDay;
    }

    public void setNumberOfDifferenceDay(Integer numberOfDifferenceDay) {
        this.numberOfDifferenceDay = numberOfDifferenceDay;
    }
}
