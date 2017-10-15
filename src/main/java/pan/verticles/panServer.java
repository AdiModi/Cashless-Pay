package pan.verticles;

import com.englishtown.vertx.hk2.HK2JerseyBinder;
import com.englishtown.vertx.hk2.HK2VertxBinder;
import com.englishtown.vertx.jersey.JerseyServer;
import generics.JsonFileReader;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import java.io.File;

public class panServer extends AbstractVerticle {

    private JsonObject configJson, jerseyConfig;

    public panServer() {
        this("D:\\Codes\\Cashless-Pay\\src\\main\\resources\\panServerConfig.json");
    }

    public panServer(String configFilePath) {
        this.configJson = new JsonFileReader().readJson(new File(configFilePath));
        if (this.configJson == null) {
            System.out.println("Error Reading Config File");
        }
        try {
            this.jerseyConfig = this.configJson.getJsonObject("jerseyConfig");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Reading Jersey Configuration");
        }
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        vertx.runOnContext(aVoid -> {
            vertx.getOrCreateContext().config()
                    .put("jersey", configJson.getJsonObject("jerseyConfig"));

            ServiceLocator serviceLocator = ServiceLocatorUtilities.bind(new HK2JerseyBinder(), new HK2VertxBinder(vertx));
            JerseyServer jerseyServer = serviceLocator.getService(JerseyServer.class);

            jerseyServer.start();
        });
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        super.stop(stopFuture);
    }
}