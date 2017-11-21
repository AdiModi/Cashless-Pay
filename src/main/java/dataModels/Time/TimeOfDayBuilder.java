package dataModels.Time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class TimeOfDayBuilder {

    private static boolean isValid(int hour, int minute, int seconds, int milliseconds) {
        return (hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59) && (seconds >= 0 && seconds <= 59) && (milliseconds >= 0 && milliseconds <= 999);
    }

    public static TimeOfDay buildTimeOfDayInstance(int hour, int minute, int seconds, int milliseconds) {
        return isValid(hour, minute, seconds, milliseconds) ? new TimeOfDay(hour, minute, seconds, milliseconds) : null;
    }

    public static TimeOfDay buildCurrentTimeOfDayInstance() {
        LocalDateTime localDateTime = ServerLocalDateTime.getLocalDateTime();
        return new TimeOfDay(localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.get(ChronoField.MILLI_OF_SECOND));
    }
}
