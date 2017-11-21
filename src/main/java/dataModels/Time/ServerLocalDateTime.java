package dataModels.Time;

import java.time.LocalDateTime;

public class ServerLocalDateTime {

    private static LocalDateTime localDateTime;

    public static synchronized LocalDateTime getLocalDateTime() {
        if (localDateTime == null) {
            localDateTime = LocalDateTime.now();
        }
        return localDateTime;
    }
}
