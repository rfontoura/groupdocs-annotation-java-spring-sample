package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.annotation.config.ServiceConfiguration;
import com.groupdocs.annotation.domain.Assets;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.handler.GroupDocsAnnotation;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.domain.GroupDocsFilePath;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * User: liosha
 * Date: 05.12.13
 * Time: 22:54
 */
@Controller
public class HomeController extends GroupDocsAnnotation {
    @Autowired
    protected ApplicationConfig applicationConfig;
    protected AnnotationHandler annotationHandler = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return index(model, request, response, "", null);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fileId", required = false) String fileId, @RequestParam(value = "fileUrl", required = false) String fileUrl) throws Exception {
        if (annotationHandler == null) {
            // Application path
            String appPath = "http://" + request.getServerName() + ":" + request.getServerPort();
            // File storage path
            String basePath = applicationConfig.getBasePath();
            // File license path
            String licensePath = applicationConfig.getLicensePath();
            // Assets path, where all js and css files will be stored
            String assetsDir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath() + "\\assets\\";
            // INITIALIZE GroupDocs Java Viewer Object
            Assets assets = new Assets(assetsDir, DOCUMENT_VIEWER);
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, licensePath, assets, Boolean.FALSE);
            annotationHandler = new AnnotationHandler(config);
            // InputDataHandler.setInputDataHandler(new CustomInputDataHandler(config));
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", annotationHandler.getHeader());
        // Initialization of Viewer with document from this path
        GroupDocsFilePath groupDocsFilePath;
        if (StringUtils.isNotEmpty(fileUrl)) {
            groupDocsFilePath = new GroupDocsFilePath(fileUrl);
        } else {
            groupDocsFilePath = new GroupDocsFilePath(fileId);
        }
        model.addAttribute("filePath", groupDocsFilePath.getPath());
        // Viewer config
        model.addAttribute("showHeader", applicationConfig.getShowHeader());
        model.addAttribute("showThumbnails", applicationConfig.getShowThumbnails());
        model.addAttribute("openThumbnails", applicationConfig.getOpenThumbnails());
        model.addAttribute("width", applicationConfig.getWidth());
        model.addAttribute("height", applicationConfig.getHeight());
        model.addAttribute("showFolderBrowser", applicationConfig.getShowFolderBrowser());
        model.addAttribute("showPrint", applicationConfig.getShowPrint());
        model.addAttribute("showDownload", applicationConfig.getShowDownload());
        model.addAttribute("showZoom", applicationConfig.getShowZoom());
        model.addAttribute("showPaging", applicationConfig.getShowPaging());
        model.addAttribute("showSearch", applicationConfig.getShowSearch());
        return "index";
    }

    @Override
    public Object getFileHandler(String path, HttpServletResponse httpServletResponse){
        try{
            return annotationHandler.getFileHandler(path, httpServletResponse);
        }catch(Exception ex){
            return null;
        }
    }

    /**
     * Download file [GET request]
     * @param path
     * @param response
     * @return
     */
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public void getFileHandler(HttpServletRequest request, HttpServletResponse response, @RequestParam("path") String path) throws Exception {
        File file = (File) getFileHandler(path, response);
        if (file != null) {
            OutputStream outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            IOUtils.copy(bufferedInputStream, outputStream);
            bufferedInputStream.close();
            fileInputStream.close();
        }
    }

    @Override
    public Object getDocumentPageImageHandler(String guid, String width, Integer quality, Boolean usePdf, Integer pageIndex) throws Exception {
        return annotationHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex);
    }

    /**
     * Get image file [GET request]
     * @param guid
     * @param width
     * @param quality
     * @param usePdf
     * @param pageIndex
     * @return
     * @throws Exception
     */
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getDocumentPageImageHandler(HttpServletRequest request, HttpServletResponse response, @RequestParam("path") String guid, @RequestParam("width") String width,
                                            @RequestParam("quality") Integer quality, @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex) throws Exception {
        File file = (File) getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex);
        OutputStream outputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        IOUtils.copy(bufferedInputStream, outputStream);
        bufferedInputStream.close();
        fileInputStream.close();
    }

    /**
     * Generate list of images/pages [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.viewDocumentHandler(request));
    }

    /**
     * Generate list of images/pages [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(annotationHandler.viewDocumentHandler(callback, data, request));
    }

    /**
     * Load tree of files from base directory [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.loadFileBrowserTreeDataHandler(request));
    }

    /**
     * Load tree of files from base directory [GET request]
     *
     * @param callback
     * @param data
     * @return
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data) {
        return jsonOut(annotationHandler.loadFileBrowserTreeDataHandler(callback, data));
    }

    /**
     * Get thumbs and other images files [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request) {
        return jsonOut(new Gson().toJson(annotationHandler.getImageUrlsHandler(request)));
    }

    /**
     * Get thumbs and other images files [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(annotationHandler.getImageUrlsHandler(callback, data, request));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.getPdf2JavaScriptHandler(request));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     *
     * @param callback
     * @param data
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data) {
        return jsonOut(annotationHandler.getPdf2JavaScriptHandler(callback, data));
    }

    /**
     * Print document [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request) {
        return typeOut(annotationHandler.getPrintableHtmlHandler(request), MediaType.TEXT_HTML);
    }

    /**
     * Print document [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(annotationHandler.getPrintableHtmlHandler(callback, data, request));
    }

    @Override
    @RequestMapping(value = GET_SCRIPT_HANDLER, method = RequestMethod.GET)
    public Object getScriptHandler(HttpServletRequest request, String name) {
        return null;
    }

    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public Object getCssHandler(HttpServletRequest request, String name) {
        return null;
    }

    @Override
    @RequestMapping(value = LIST_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object listAnnotationsHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = EXPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object exportAnnotationsHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = GET_PDF_VERSION_OF_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public Object getPdfVersionOfDocumentHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = CREATE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object createAnnotationHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = GET_AVATAR_HANDLER, method = RequestMethod.GET)
    public Object getAvatarHandler(HttpServletRequest request, String userId) {
        return null;
    }

    @Override
    @RequestMapping(value = ADD_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object addAnnotationReplyHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = EDIT_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object editAnnotationReplyHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = DELETE_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationReplyHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = DELETE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = SAVE_TEXT_FIELD_HANDLER, method = RequestMethod.POST)
    public Object saveTextFieldHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = SET_TEXT_FIELD_COLOR_HANDLER, method = RequestMethod.POST)
    public Object setTextFieldColorHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = MOVE_ANNOTATION_MARKER_HANDLER, method = RequestMethod.POST)
    public Object moveAnnotationMarkerHandler(HttpServletRequest request) {
        return null;
    }

    protected static ResponseEntity<String> jsonOut(Object obj) {
        return typeOut(obj, MediaType.APPLICATION_JSON);
    }

    protected static ResponseEntity<String> typeOut(Object obj, MediaType mediaType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (mediaType == MediaType.APPLICATION_JSON) {
            httpHeaders.set("Content-type", "application/json;charset=UTF-8");
        } else {
            httpHeaders.setContentType(mediaType);
        }
        return new ResponseEntity<String>(obj.toString(), httpHeaders, HttpStatus.CREATED);
    }
}
