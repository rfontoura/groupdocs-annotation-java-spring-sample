package com.groupdocs;

import com.groupdocs.annotation.common.ICallback;
import com.groupdocs.annotation.common.Pair;
import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.common.StorageType;
import com.groupdocs.annotation.data.common.StoreLogic;
import com.groupdocs.annotation.data.connector.IConnector;
import com.groupdocs.annotation.data.connector.data.JsonDataConnector;
import com.groupdocs.annotation.data.connector.data.XmlDataConnector;
import com.groupdocs.annotation.data.connector.db.MssqlDatabaseConnector;
import com.groupdocs.annotation.data.connector.db.MysqlDatabaseConnector;
import com.groupdocs.annotation.data.connector.db.PostgresqlDatabaseConnector;
import com.groupdocs.annotation.data.connector.db.SqliteDatabaseConnector;
import com.groupdocs.annotation.data.tables.interfaces.IDocument;
import com.groupdocs.annotation.data.tables.interfaces.IUser;
import com.groupdocs.annotation.enums.AccessRights;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.handler.IGroupDocsAnnotation;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.data.connector.CustomDatabaseConnector;
import com.groupdocs.data.connector.ICustomConnector;
import com.groupdocs.viewer.config.ServiceConfiguration;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex Bobkov
 */
public abstract class HomeControllerBase implements IGroupDocsAnnotation {
    @Autowired
    protected ApplicationConfig applicationConfig;
    private AnnotationHandler annotationHandler;

    /**
     * Write object as json
     * @param obj object to write
     * @return response object
     */
    protected static ResponseEntity<String> writeOutputJson(Object obj) {
        return writeOutput(obj, MediaType.APPLICATION_JSON);
    }

    /**
     * Write object to response with provided media type
     * @param obj object to write
     * @param mediaType media type
     * @return response object
     */
    protected static ResponseEntity<String> writeOutput(Object obj, MediaType mediaType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (mediaType == MediaType.APPLICATION_JSON) {
            httpHeaders.set("Content-type", "application/json;charset=UTF-8");
        } else {
            httpHeaders.setContentType(mediaType);
        }
        return new ResponseEntity<String>(obj.toString(), httpHeaders, HttpStatus.OK);
    }

    /**
     * Write stream to response
     * @param o stream
     * @param response http servlet response
     */
    protected void writeOutput(Object o, HttpServletResponse response) {
        if (o instanceof InputStream) {
            writeOutput((InputStream) o, response);
        }
    }

    /**
     * Write stream to response
     * @param inputStream stream for write
     * @param response http servlet response
     */
    protected void writeOutput(InputStream inputStream, HttpServletResponse response) {
        try {
            IOUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HomeControllerBase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utils.closeStreams(inputStream);
        }
    }

    /**
     * Get or create annotation handler
     * @return annotation handler
     */
    protected AnnotationHandler annotationHandler() {
        if (annotationHandler == null) {
            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Vilnius"));
            ServiceConfiguration serviceConfiguration = new ServiceConfiguration(applicationConfig);
            String tempPath = serviceConfiguration.getTempDir();
            try {
//                annotationHandler = new AnnotationHandler(serviceConfiguration);

                IConnector connector = null;
                String storageTypeString = applicationConfig.getStorageType();
                String dbServer = applicationConfig.getDbServer();
                Integer dbPort = applicationConfig.getDbPort();
                String dbName = applicationConfig.getDbName();
                String dbUsername = applicationConfig.getDbUsername();
                String dbPassword = applicationConfig.getDbPassword();
                StoreLogic storeLogic = StoreLogic.fromValue(applicationConfig.getStoreLogic());
                String storagePath = Utils.or(applicationConfig.getStoragePath(), tempPath);

                if (storageTypeString != null && !storageTypeString.isEmpty()) {
                    StorageType storageType = StorageType.fromValue(storageTypeString);
                    if (storageType == null) {
                        throw new AnnotationException("Unknown storage type: " + storageTypeString);
                    }
                    switch (storageType) {
                        case DEFAULT:
                            connector = null;
                            break;
                        case SQLITE:
                            connector = new SqliteDatabaseConnector(storagePath, "customSQLITEdatabaseStorage.db");
                            break;
                        case MYSQL:
                            connector = new MysqlDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                        case MSSQL:
                            connector = new MssqlDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                        case JSON:
                            connector = new JsonDataConnector(storagePath, storeLogic);
                            break;
                        case XML:
                            connector = new XmlDataConnector(storagePath, storeLogic);
                            break;
                        case POSTGRE:
                            connector = new PostgresqlDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                        case CUSTOM:
                            connector = new CustomDatabaseConnector(dbServer, dbPort, dbName, dbUsername, dbPassword);
                            break;
                    }
                }
//                // Initialize constructors for create custom entities instead of embedded
//                AnnotationConstructor.setConstructor(new IConstructor<IAnnotation>() {
//                    @Override
//                    public IAnnotation create() {
//                        return new MyCustomEntityClass();
//                    }
//
//                    @Override
//                    public IAnnotation create(IAnnotation obj) {
//                        MyCustomEntityClass /* MyCustomEntityClass implements IAnnotation */ myCustomEntityClass = new MyCustomEntityClass();
//                        myCustomEntityClass.setAnyPropertyIfNeed(object.getAnyproperty());
//                        return myCustomEntityClass;
//                    }
//                });
//                CollaboratorConstructor.setConstructor(...); ...

                // It need for date formatting
                Locale.setDefault(Locale.CANADA);
                //
                annotationHandler = new AnnotationHandler(serviceConfiguration, connector);
                if (connector instanceof ICustomConnector) {
                    ((ICustomConnector) connector).setEnvironmentCreator(annotationHandler);
                }
                // This callback will be called for each case when collaborator should be created
                annotationHandler.setCollaboratorCallback(new ICallback<Pair<Integer, Color>, Pair<IUser, IDocument>>() {
                    @Override
                    public Pair<Integer, Color> onCallback(Pair<IUser, IDocument> param) {
                /*
                IUser user = param.one;
                IDocument document = param.two;
                */
                        // User collaborator for document will be created with returned access rights and color
                        // Default CollaboratorCallback is made similarly
                        return new Pair<Integer, Color>(AccessRights.All.value(), Color.red);
                    }
                });

//        AnnotationHandler annotationHandler = new AnnotationHandler(serviceConfiguration, connector, new CustomInputDataHandler(applicationConfig));
//        annotationHandler.setInputDataHandler(new CustomInputDataHandler(applicationConfig));

                // Will be called for each case when collaborator ask access to some event from AnnotationEvent
                // Return value have priority is more than at Collaborator rights
//        annotationHandler.setAccessCallback(new ICallback<Boolean, Three<AnnotationEvent,IUser,IDocument>>() {
//            @Override
//            public Boolean onCallback(Three<AnnotationEvent, IUser, IDocument> param) {
//                AnnotationEvent annotationEvent = param.one;
//                switch (annotationEvent) {
//                    case CreateAnnotation:
//                        // Check permissions and return true of false
//                        break;
//                    case DeleteAnnotation:
//                        // Check permissions and return true of false
//                        break;
//                    // ...
//                }
//                return true;
//            }
//        });
            } catch (Exception e) {
                // TODO: logger
                e.printStackTrace();
            }
        }
        return annotationHandler;
    }
}
