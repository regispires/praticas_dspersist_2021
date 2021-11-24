package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/dspersist2021",
                    "postgres","postgres");
            System.out.println("Conectado");
            return conn;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
