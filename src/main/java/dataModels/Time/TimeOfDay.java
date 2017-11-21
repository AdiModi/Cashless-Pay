package dataModels.Time;

import lombok.Getter;

public class TimeOfDay {

    @Getter
    private int hour, minute, seconds, milliseconds;

    TimeOfDay(int hour, int minute, int seconds, int milliseconds) {
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }
}