package pl.yuriipodria.ecommerce.payu;

public class PayUConfiguration {
    String posId;
    String md5;
    String clientId;
    String clientSecret;
    boolean sandboxMode;

    public PayUConfiguration(String posId, String md5, String clientId, String clientSecret, boolean sandboxMode) {
        this.posId = posId;
        this.md5 = md5;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.sandboxMode = sandboxMode;
    }

    public static PayUConfiguration byEnvVariables() {
        return new PayUConfiguration(
                System.getenv("PAYU_POS_ID"),
                System.getenv("PAYU_MD5"),
                System.getenv("PAYU_CLIENT_ID"),
                System.getenv("PAYU_CLIENT_SECRET"),
                false
        );
    }

    public static PayUConfiguration sandbox() {
        return new PayUConfiguration(
                "300746",
                "fsdhfsdgjfgjfg",
                "300746",
                "oinsdgaugoigoia",
                true
        );
    }
}
