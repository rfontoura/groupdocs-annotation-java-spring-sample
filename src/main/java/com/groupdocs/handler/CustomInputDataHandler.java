package com.groupdocs.handler;

import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.FileType;
import com.groupdocs.viewer.handlers.input.InputDataHandler;
import com.groupdocs.viewer.resources.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Input data handler - custom implementation
 * @author Aleksey Permyakov, Alex Bobkov
 */
public class CustomInputDataHandler extends InputDataHandler {
    private final Map<String, String> fileId2FilePath = new HashMap<String, String>();
    private final Map<String, String> fileId2FileName = new HashMap<String, String>();
    private String basePath = null;

    /**
     * Custom constructor
     * @param serviceConfiguration service configuration
     */
    public CustomInputDataHandler(ServiceConfiguration serviceConfiguration) {
        basePath = serviceConfiguration.getBasePath();
    }

    /**
     * Get list of files
     * @param directory directory to get files
     * @return list of files
     */
    @Override
    public Map<String, String> getFileList(String directory) {
        File[] files = new File(basePath + directory).listFiles();
        for (File file : files) {
            String fileId = Utils.encodeData(file.getAbsolutePath());
            fileId2FilePath.put(fileId, file.getAbsolutePath());
            fileId2FileName.put(fileId, file.getName());
        }
        return fileId2FileName;
    }

    /**
     * Get file stream
     * @param guid file identifier
     * @return file stream
     */
    @Override
    public InputStream getFile(String guid) {
        try {
            return new FileInputStream(fileId2FilePath.get(guid));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * Get type of file
     * @param guid file identifier
     * @return type of file
     */
    @Override
    public FileType getFileType(String guid) {
        String fileName = new File(fileId2FileName.get(guid)).getName();
        if (fileName.contains(".")) {
            return FileType.valueOf(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());
        }
        return FileType.DIRECTORY;
    }

    /**
     * Save file - for upload functional
     * @param inputStream file stream
     * @param fileName file name
     * @param timeToLive time in milliseconds
     * @return file identifier
     */
    @Override
    public String saveFile(InputStream inputStream, String fileName, Integer timeToLive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
