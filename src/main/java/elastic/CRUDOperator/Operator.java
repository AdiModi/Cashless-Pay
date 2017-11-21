package elastic.CRUDOperator;

import com.google.gson.Gson;
import elastic.Client;
import io.vertx.core.json.JsonObject;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

class Operator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Operator.class);
    private JsonObject configJson;
    private RestHighLevelClient restHighLevelClient;
    private Gson gson;

    public Operator() {
        LOGGER.info("Getting The Singleton Client...");
        gson = new Gson();
        restHighLevelClient = Client.getClient();
    }

    public GetResponse GET(String index, String type, String id) {

        LOGGER.info("GET Request Received...");

        GetRequest getRequest = new GetRequest();
        GetResponse getResponse = null;
        if (index == null || type == null || id == null) {
            return null;
        }
        getRequest.index(index);
        getRequest.type(type);
        getRequest.id(id.toLowerCase());
        try {
            getResponse = restHighLevelClient.get(getRequest);
            LOGGER.info("GET Request Successfully Executed");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return getResponse;
        }
    }

    public SearchResponse SEARCH(String indices, String type, String[] fields, String[] fieldNames, String[] fieldValues, AggregationBuilder aggregationBuilder, SortBuilder sortBuilder, Long size) {
        /*QueryBuilder queryBuilder = QueryBuilders.??();*/

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(indices);
        searchRequest.searchType(type);
        return null;
    }
}