import generics.JsonFileReader;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ServerDeployer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerDeployer.class);

    private static Vertx vertx;
    private static JsonFileReader jsonFileReader;
    private static JsonObject configJson;
    private static JsonArray verticlesToDeploy;

    static {
        jsonFileReader = new JsonFileReader();
        configJson = jsonFileReader.readJson(new File("D:\\Codes\\Cashless-Pay\\src\\main\\resources\\ServerDeployer.json"));
        if (configJson == null) {
            LOGGER.error("Reading Config File, Quitting");
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        vertx = Vertx.vertx();
        verticlesToDeploy = configJson.getJsonArray("verticlesToDeploy");
        for (int i = 0; i < verticlesToDeploy.size(); i++) {
            LOGGER.info("Deploying {} verticle...", verticlesToDeploy.getString(i));
            vertx.deployVerticle(verticlesToDeploy.getString(i), stringAsyncResult -> {
                if (stringAsyncResult.succeeded()) {
                    LOGGER.info("Deployment of verticle successful with id: {}", stringAsyncResult.result());
                } else {
                    LOGGER.error("Deployment failed!");
                    System.out.println(stringAsyncResult.cause());
                }
            });
        }
    }
}