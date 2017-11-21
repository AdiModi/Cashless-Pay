package dataModels.Time;

import java.time.LocalDateTime;

public class DateBuilder {

    private static boolean isValid(int day, int month, int year) {
        if (month < 0 || month > 12) {
            return false;
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day < 0 || day > 31) {
                return false;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day < 0 || day > 30) {
                return false;
            }
        } else if (month == 2) {
            if (year % 400 == 0 && year % 100 != 0 || year % 4 == 0) {
                if (day < 0 || day > 29) {
                    return false;
                }
            } else {
                if (day < 0 || day > 28) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Date buildDateInstance(int day, int month, int year) {
        return (isValid(day, month, year)) ? new Date(day, month, year) : null;
    }

    public static Date buildCurrentDateInstance() {
        LocalDateTime localDateTime = ServerLocalDateTime.getLocalDateTime();
        return new Date(localDateTime.getDayOfMonth(), localDateTime.getMonthValue(), localDateTime.getYear());
    }
}