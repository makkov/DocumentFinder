package ru.makkov.documentFinder.repository.connectionManager;

import java.sql.Connection;

/**
 * interface for getting database connection
 */
public interface ConnectionManager {
    public Connection getConnection();
}
