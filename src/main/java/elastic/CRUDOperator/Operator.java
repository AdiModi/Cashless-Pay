package elastic.CRUDOperator;

import elastic.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Operator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Operator.class);

    private RestHighLevelClient restHighLevelClient;

    public Operator() {
        LOGGER.info("Getting The Singleton Transport Client");
        restHighLevelClient = Client.getClient();
    }
}