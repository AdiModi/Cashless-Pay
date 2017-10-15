package elastic.AdminOperator;

import elastic.Client;
import org.elasticsearch.client.AdminClient;

public class Operator {
    private static AdminClient adminClient;

    static {
        adminClient = Client.getClient().getAdminClient();
    }
}
