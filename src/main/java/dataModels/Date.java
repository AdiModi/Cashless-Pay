package dataModels;

import generics.JsonFileReader;
import io.vertx.core.json.JsonObject;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {

    private static final Logger LOGGER = LoggerFactory.getLogger(Date.class);
    private static JsonObject configJson;

    static {
        configJson = new JsonFileReader().readJson(new File("D:\\Codes\\Cashless-Pay\\src\\main\\resources\\DateConfig.json"));
        if (configJson == null) {
            LOGGER.error("Reading Config File, Quitting");
            System.exit(1);
        }
    }

    @Getter
    @Setter
    int day, month, year;

    public Date(int day, int month, int year) {
        if (isValid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public Date(int day) {
        super();
    }

    public boolean isValid(int day, int month, int year) {

        String dateToValidate = day + "-" + month + "-" + year;
        boolean result = false;

        if (dateToValidate == null) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(configJson.getString("dateFormat"));

        try {
            java.util.Date date = simpleDateFormat.parse(dateToValidate);
            result = true;
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
