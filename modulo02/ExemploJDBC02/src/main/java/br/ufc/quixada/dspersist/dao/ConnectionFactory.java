package br.ufc.quixada.dspersist.dao;

import br.ufc.quixada.dspersist.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        System.out.println(AppConfig.PROPS.getProperty("jdbc.url"));
        System.out.println(AppConfig.PROPS.getProperty("jdbc.usuario"));
        return DriverManager.getConnection(AppConfig.PROPS.getProperty("jdbc.url"),
                AppConfig.PROPS.getProperty("jdbc.usuario"), AppConfig.PROPS.getProperty("jdbc.senha"));
    }

}
