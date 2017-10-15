package elastic;

import generics.JsonFileReader;
import io.vertx.core.json.JsonObject;
import lombok.Getter;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.File;

public class Client {

    private static String configFilePath = "D:\\Codes\\Cashless-Pay\\src\\main\\resources\\ITCanteenServerConfig.json";
    private static Client client = new Client();
    private JsonObject configJson;
    private Settings settings;
    @Getter
    private TransportClient transportClient;
    @Getter
    private AdminClient adminClient;

    private Client() {
        this.configJson = new JsonFileReader().readJson(new File(configFilePath));
        if (this.configJson == null) {
            System.out.println("Error Reading Config File");
        }
        this.settings = Settings.builder()
                .put("cluster.name", this.configJson.getValue("cluster.name"))
                .put("host", this.configJson.getValue("host"))
                .put("port", this.configJson.getValue("port")).build();
        this.transportClient = new PreBuiltTransportClient(this.settings);
        this.adminClient = transportClient.admin();
    }

    public static synchronized Client getClient() {
        return client;
    }
}