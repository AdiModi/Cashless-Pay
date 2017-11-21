package constants;

public class ResourcesPath {
    public static final String DIR_RESOURCES_PATH = "D:\\Codes\\Cashless-Pay\\src\\main\\resources";
    public static final String DIR_CONFIGS_PATH = DIR_RESOURCES_PATH + "\\configs";

    public static class Configs {
        public static final String FILE_AUTHENTICATED_COOKIE_VALUES_CONFIG_PATH = DIR_CONFIGS_PATH + "\\AuthenticatedCookieValues.json";
        public static final String FILE_ELASTIC_CONFIG_PATH = DIR_CONFIGS_PATH + "\\ElasticConfig.json";

        public static final String FILE_IT_CANTEEN_VERTICLE_CONFIG_PATH = DIR_CONFIGS_PATH + "\\ITCanteenVerticleConfig.json";
        public static final String FILE_PAN_VERTICLE_CONFIG_PATH = DIR_CONFIGS_PATH + "\\PanVerticleConfig.json";
        public static final String FILE_CASH_VERTICLE_CONFIG_PATH = DIR_CONFIGS_PATH + "\\CashVerticleConfig.json";

        public static final String FILE_SERVER_DEPLOYER_CONFIG_PATH = DIR_CONFIGS_PATH + "\\ServerDeployer.json";
    }
}