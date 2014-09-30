package com.groupdocs.connector;

import com.groupdocs.annotation.connector.StorageType;
import com.groupdocs.annotation.connector.db.AbstractDatabaseConnector;
import com.groupdocs.annotation.connector.db.IDatabaseConnector;
import com.groupdocs.config.ApplicationConfig;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Custom connector for MySQL database
 * GroupDocs.Annotation have embedded MySQL connector
 * So this connector just example
 *
 * @author Aleksey Permyakov (09.09.2014)
 */
public class CustomDatabaseConnector extends AbstractDatabaseConnector {
    private static final String CONNECTION_STRING = "jdbc:mysql://%s:%d/%s?user=%s&password=%s";

    private String dbDriver;
    private String dbServer;
    private int dbPort;
    private String dbName;
    private String dbUsername;
    private String dbPassword;

    /**
     * Create custom database connector
     * @param dbDriver      Database driver (com.mysql.jdbc.Driver)
     * @param dbServer      Database server (192.168.204.128)
     * @param dbPort        Database port (1433)
     * @param dbName        Database name (AnnotationDB)
     * @param dbUsername    Database user name
     * @param dbPassword    Database user password
     */
    public CustomDatabaseConnector(String dbDriver, String dbServer, int dbPort, String dbName, String dbUsername, String dbPassword) {
        this.dbDriver = dbDriver;
        this.dbServer = dbServer;
        this.dbPort = dbPort;
        this.dbName = dbName;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }

    @Override
    public ConnectionSource getConnection() {
        return getConnection(dbDriver, String.format(CONNECTION_STRING, dbServer, dbPort, dbName, dbUsername, dbPassword));
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public void setDbServer(String dbServer) {
        this.dbServer = dbServer;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    @Override
    public StorageType getStorageType() {
        return StorageType.CUSTOM;
    }
}
