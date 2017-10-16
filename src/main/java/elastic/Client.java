package elastic;

import generics.JsonFileReader;
import io.vertx.core.json.JsonObject;
import lombok.Getter;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.ClusterAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    private static String configFilePath = "D:\\Codes\\Cashless-Pay\\src\\main\\resources\\ITCanteenServerConfig.json";
    private static Client client = new Client();
    private JsonObject configJson;
    private Settings settings;
    @Getter
    private TransportClient transportClient;
    @Getter
    private AdminClient adminClient;
    @Getter
    private ClusterAdminClient clusterAdminClient;

    private Client() {
        this.configJson = new JsonFileReader().readJson(new File(configFilePath));
        if (this.configJson == null) {
            LOGGER.error("Reading Config File, Quitting");
            System.exit(1);
        }
        this.settings = Settings.builder()
                .put("cluster.name", this.configJson.getValue("cluster.name"))
                .put("host", this.configJson.getValue("host"))
                .put("port", this.configJson.getValue("port")).build();
        this.transportClient = new PreBuiltTransportClient(this.settings);
        this.adminClient = transportClient.admin();
        LOGGER.info("Client Instance Created!");
    }

    public static synchronized Client getClient() {
        return client;
    }
}