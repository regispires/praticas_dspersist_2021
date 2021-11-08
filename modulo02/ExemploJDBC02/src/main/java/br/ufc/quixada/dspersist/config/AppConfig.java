package br.ufc.quixada.dspersist.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class AppConfig {

    public static Properties PROPS = null;

    static {
        try {
            Properties props = new Properties();
            InputStream is = AppConfig.class.getResourceAsStream("/config.properties");
            System.out.println(is);
            props.load(is);
            PROPS = props;
            System.out.println(PROPS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
