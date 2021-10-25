import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(AppConfig.PROPS.getProperty("jdbc.url"),
                AppConfig.PROPS.getProperty("jdbc.usuario"),AppConfig.PROPS.getProperty("jdbc.senha"));
    }

}
