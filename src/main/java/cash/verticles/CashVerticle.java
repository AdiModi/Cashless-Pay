package cash.verticles;

import com.englishtown.vertx.hk2.HK2JerseyBinder;
import com.englishtown.vertx.hk2.HK2VertxBinder;
import com.englishtown.vertx.jersey.JerseyServer;
import constants.ResourcesPath;
import generics.JsonFileReader;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CashVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(CashVerticle.class);

    private JsonObject configJson, jerseyConfig;

    public CashVerticle() {
        this(ResourcesPath.Configs.FILE_CASH_VERTICLE_CONFIG_PATH);
    }

    public CashVerticle(String configFilePath) {
        this.configJson = new JsonFileReader().readJson(new File(configFilePath));
        if (this.configJson == null) {
            LOGGER.error("Error Reading Config File, Quitting!");
            System.exit(1);
        }
        try {
            this.jerseyConfig = this.configJson.getJsonObject("jerseyConfig");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Error Reading Jersey Config File, Quitting!");
        }
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        vertx.runOnContext(aVoid -> {
            vertx.getOrCreateContext().config()
                    .put("jersey", configJson.getJsonObject("jerseyConfig"));

            ServiceLocator serviceLocator = ServiceLocatorUtilities.bind(new HK2JerseyBinder(), new HK2VertxBinder(vertx));
            JerseyServer jerseyServer = serviceLocator.getService(JerseyServer.class);
            LOGGER.info("Staring Jersey Server for {}", CashVerticle.class.getCanonicalName());
            jerseyServer.start();
        });
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        super.stop(stopFuture);
    }
}