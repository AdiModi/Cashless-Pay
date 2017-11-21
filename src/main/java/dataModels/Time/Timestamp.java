package dataModels.Time;

import lombok.Getter;

public class Timestamp {

    @Getter
    private Date date;
    private TimeOfDay timeOfDay;

    public Timestamp(Date date, TimeOfDay timeOfDay) {
        this.date = date;
        this.timeOfDay = timeOfDay;
    }
}