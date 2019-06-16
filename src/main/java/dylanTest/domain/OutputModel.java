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

    public String generatOutputString() {
        String beforeDay, beforeMonth, afterMonth, afterDay;
        if(this.getDateBefore().getMonth() < 10) {
            beforeMonth = "0" + this.getDateBefore().getMonth();
        } else {
            beforeMonth = String.valueOf(getDateBefore().getMonth());
        }

        if(this.getDateBefore().getDay() < 10) {
            beforeDay = "0" + this.getDateBefore().getDay();
        } else {
            beforeDay = String.valueOf(getDateBefore().getDay());
        }

        if(this.getDateAfter().getMonth() < 10) {
            afterMonth = "0" + this.getDateAfter().getMonth();
        } else {
            afterMonth = String.valueOf(getDateAfter().getMonth());
        }

        if(this.getDateAfter().getDay() < 10) {
            afterDay = "0" + this.getDateAfter().getDay();
        } else {
            afterDay = String.valueOf(getDateAfter().getDay());
        }

        return beforeDay + " " + beforeMonth + " " + getDateBefore().getYear() + ", "
                + afterDay + " " + afterMonth + " " + getDateAfter().getYear() + " " + numberOfDifferenceDay;
    }

}
