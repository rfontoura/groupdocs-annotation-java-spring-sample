package com.groupdocs;

import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.handler.GroupDocsAnnotation;
import com.groupdocs.annotation.utils.Utils;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex Bobkov
 */
public abstract class HomeControllerBase extends GroupDocsAnnotation {
    @Autowired
    protected ApplicationConfig applicationConfig;
    private AnnotationHandler annotationHandler;

    /**
     * Write object as json
     *
     * @param obj object to write
     * @return response object
     */
    protected static ResponseEntity<String> writeOutputJson(Object obj) {
        return writeOutput(obj, MediaType.APPLICATION_JSON);
    }

    /**
     * Write object to response with provided media type
     *
     * @param obj       object to write
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
     *
     * @param o        stream
     * @param response http servlet response
     */
    protected void writeOutput(Object o, HttpServletResponse response) {
        if (o instanceof InputStream) {
            writeOutput((InputStream) o, response);
        }
    }

    /**
     * Write stream to response
     *
     * @param inputStream stream for write
     * @param response    http servlet response
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
     *
     * @return annotation handler
     */
    protected AnnotationHandler annotationHandler() {
        if (annotationHandler == null) {
            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Vilnius"));
            ServiceConfiguration serviceConfiguration = new ServiceConfiguration(applicationConfig);
            try {
                annotationHandler = new AnnotationHandler(serviceConfiguration);

//                annotationHandler = new AnnotationHandler(serviceConfiguration, new CustomDatabaseConnector(applicationConfig));

//                annotationHandler = new AnnotationHandler(config, new CustomInputDataHandler(config));
//                InputDataHandler.setInputDataHandler(new CustomInputDataHandler(config));
            } catch (Exception e) {
                // TODO: logger
                e.printStackTrace();
            }
        }
        return annotationHandler;
    }
}
