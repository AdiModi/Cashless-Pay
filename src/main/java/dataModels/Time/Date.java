package dataModels.Time;

import lombok.Getter;

public class Date {

    @Getter
    private int day, month, year;

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}