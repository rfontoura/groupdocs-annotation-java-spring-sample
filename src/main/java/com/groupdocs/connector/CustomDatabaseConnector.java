package com.groupdocs.connector;

import com.groupdocs.annotation.connector.IDatabaseConnector;
import com.groupdocs.config.ApplicationConfig;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Custom database connector
 *
 * @author Aleksey Permyakov (09.09.2014)
 */
public class CustomDatabaseConnector implements IDatabaseConnector {
    private String dbDriver;
    private String dbConnection;

    /**
     * Custom constructor
     *
     * @param applicationConfig application config
     */
    public CustomDatabaseConnector(ApplicationConfig applicationConfig) {
        dbDriver = applicationConfig.getDbDriver();
        dbConnection = applicationConfig.getDbConnection();
    }

    /**
     * Create connection to database
     *
     * @return database connection
     */
    @Override
    public ConnectionSource getConnection() {
        try {
            // Load driver class
            Class.forName(dbDriver);
            // create a connection source to our database
            return new JdbcConnectionSource(dbConnection);
        } catch (Exception ex) {
            Logger.getLogger(CustomDatabaseConnector.class.getName()).log(Level.SEVERE, "Error during create Sql connection (Will be used default SQLite database): " + ex.getMessage());
            return null;
        }
    }
}
