package elastic.AdminOperator;

import elastic.Client;
import org.elasticsearch.client.AdminClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Operator.class);

    private static AdminClient adminClient;

    static {
        adminClient = Client.getClient().getAdminClient();
    }
}
