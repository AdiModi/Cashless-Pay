package generics;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.ws.rs.core.Cookie;
import java.io.File;

public class CookieAuthenticator {

    private static JsonFileReader jsonFileReader;
    private static JsonObject jsonObject;
    private static JsonArray jsonArray;

    static {
        jsonFileReader = new JsonFileReader();
        jsonObject = jsonFileReader.readJson(new File("D:\\Codes\\Cashless-Pay\\src\\main\\resources\\AuthenticatedCookieValues.json"));
        jsonArray = jsonObject.getJsonArray("AuthenticatedCookieValues");
    }

    public CookieAuthenticator() {
        super();
    }

    public boolean authenticateStandardCookie(Cookie cookie) {

        boolean result = false;
        String IPv4Address = cookie.getValue().substring(0, 11);
        String MACAddress = cookie.getValue().substring(11);

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            /*System.out.println(IPv4Address);
            System.out.println(MACAddress);
            System.out.println(jsonObject.getString("IPv4Address"));
            System.out.println(jsonObject.getString("MACAddress"));*/
            if (IPv4Address.equals(jsonObject.getString("IPv4Address")) && MACAddress.equals(jsonObject.getString("MACAddress"))) {
                result = true;
                break;
            }
        }
        return result;
    }

    /*public static void main(String[] args) {
        CookieGenerator cookieGenerator = new CookieGenerator();
        CookieAuthenticator cookieAuthenticator = new CookieAuthenticator();
        System.out.println(cookieAuthenticator.authenticateStandardCookie(cookieGenerator.generateStandardCookie().getCookie()));
    }*/
}
