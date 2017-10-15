import io.vertx.core.Vertx;
import itCanteen.verticles.ITCanteenServer;

public class ServerDeployer {

    private static Vertx vertx;

    public static void main(String[] args) {

        vertx = Vertx.vertx();
        ITCanteenServer itCanteenServer = new ITCanteenServer();

        vertx.deployVerticle(itCanteenServer, stringAsyncResult -> {
            if (stringAsyncResult.failed()) {
                System.out.println("Verticle Deployment Failed");
                System.out.println(stringAsyncResult.cause());
            }
        });
    }
}