package com.groupdocs;

import com.groupdocs.annotation.handler.GroupDocsAnnotation;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

import com.groupdocs.annotation.utils.Utils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * @author Alex Bobkov
 */
public abstract class HomeControllerBase extends GroupDocsAnnotation {

    protected static ResponseEntity<String> writeOutputJson(Object obj) {
        return writeOutput(obj, MediaType.APPLICATION_JSON);
    }

    protected static ResponseEntity<String> writeOutput(Object obj, MediaType mediaType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (mediaType == MediaType.APPLICATION_JSON) {
            httpHeaders.set("Content-type", "application/json;charset=UTF-8");
        } else {
            httpHeaders.setContentType(mediaType);
        }
        return new ResponseEntity<String>(obj.toString(), httpHeaders, HttpStatus.CREATED);
    }

    protected void writeOutput(Object o, HttpServletResponse response) {
        if (o instanceof InputStream){
            writeOutput((InputStream) o, response);
        }
    }

    protected void writeOutput(InputStream inputStream, HttpServletResponse response) {
        try {
            IOUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HomeControllerBase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utils.closeStreams(inputStream);
        }
    }

    protected int getIntFromColor(Color color) {
        return getIntFromColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    protected int getIntFromColor(float red, float green, float blue) {
        int R = Math.round(255 * red);
        int G = Math.round(255 * green);
        int B = Math.round(255 * blue);

        R = (R << 16) & 0x00FF0000;
        G = (G << 8) & 0x0000FF00;
        B = B & 0x000000FF;

        return 0xFF000000 | R | G | B;
    }
}
