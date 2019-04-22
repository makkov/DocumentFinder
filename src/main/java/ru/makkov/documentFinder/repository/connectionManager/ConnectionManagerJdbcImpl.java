package ru.makkov.documentFinder.repository.connectionManager;


import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbcImpl implements ConnectionManager {

    private static ConnectionManager connectionManager;
    final static Logger LOGGER = Logger.getLogger(ConnectionManager.class);

    private ConnectionManagerJdbcImpl() {
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerJdbcImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/result",
                    "postgres",
                    "122544");

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error(e.getMessage() + " Database connection error\n");
        }
        return connection;
    }
}
