import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    public static Properties PROPS = null;

    static {
        try {
            Properties props = new Properties();
            InputStream is = AppConfig.class.getResourceAsStream("config.properties");
            props.load(is);
            PROPS = props;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
