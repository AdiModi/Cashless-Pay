package elastic;

import generics.JsonFileReader;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    private static String configFilePath = "D:\\Codes\\Cashless-Pay\\src\\main\\resources\\ElasticConfig.json";
    private static Client client = null;
    private static JsonObject configJson;
    private RestHighLevelClient restHighLevelClient;

    private Client() {

        configJson = new JsonFileReader().readJson(new File(configFilePath));
        if (configJson == null) {
            LOGGER.error("Reading Config File, Quitting");
            System.exit(1);
        }

        JsonArray httpHostsJsonArray = configJson.getJsonArray("httpHosts");
        HttpHost[] httpHosts = new HttpHost[httpHostsJsonArray.size()];
        for (int i = 0; i < httpHostsJsonArray.size(); i++) {
            JsonObject jsonObject = httpHostsJsonArray.getJsonObject(i);
            httpHosts[i] = new HttpHost(jsonObject.getString("host"), jsonObject.getInteger("port"));
        }

        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);
        restHighLevelClient = new RestHighLevelClient(restClientBuilder);
        LOGGER.info("Client Instance Created!");
    }

    public static synchronized RestHighLevelClient getClient() {
        if (client == null) {
            client = new Client();
        }
        return client.restHighLevelClient;
    }
}