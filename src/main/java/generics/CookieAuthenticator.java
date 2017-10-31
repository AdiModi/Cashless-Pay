package generics;

import constants.ResourcesPath;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Cookie;
import java.io.File;

public class CookieAuthenticator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookieAuthenticator.class);

    private static JsonFileReader jsonFileReader;
    private static JsonObject jsonObject;
    private static JsonArray jsonArray;

    static {
        jsonFileReader = new JsonFileReader();
        jsonObject = jsonFileReader.readJson(new File(ResourcesPath.Configs.FILE_AUTHENTICATED_COOKIE_VALUES_CONFIG_PATH));
        jsonArray = jsonObject.getJsonArray("AuthenticatedCookieValues");
    }

    public CookieAuthenticator() {
        super();
    }

    public boolean authenticateStandardCookie(Cookie cookie) {

        boolean result = false;
        String IPv4Address = cookie.getValue().substring(0, 11);
        LOGGER.info("Authentication Request Received for IPv4 Address as: {}", IPv4Address);
        String MACAddress = cookie.getValue().substring(11);
        LOGGER.info("Authentication Request Received for MAC Address as: {}", MACAddress);

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            if (IPv4Address.equals(jsonObject.getString("IPv4Address")) && MACAddress.equals(jsonObject.getString("MACAddress"))) {
                result = true;
                break;
            }
        }
        return result;
    }
}
