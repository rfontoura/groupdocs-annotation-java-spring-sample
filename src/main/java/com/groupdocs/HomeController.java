package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.annotation.config.ServiceConfiguration;
import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.handler.GroupDocsAnnotation;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.domain.GroupDocsFilePath;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

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
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "userName", required = false) String userName) throws Exception {
        return index(model, request, response, "/files/GroupDocs_Demo.doc", null, userName);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fileId", required = false) String fileId, @RequestParam(value = "fileUrl", required = false) String fileUrl, @RequestParam(value = "userName", required = false) final String userName) throws Exception {
        if (annotationHandler == null) {
            // Application path
            String appPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            // File storage path
            String basePath = applicationConfig.getBasePath();
            // File license path
            String licensePath = applicationConfig.getLicensePath();
            // INITIALIZE GroupDocs Java Annotation Object
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, licensePath, Boolean.FALSE);
            annotationHandler = new AnnotationHandler(config);
            // InputDataHandler.setInputDataHandler(new CustomInputDataHandler(config));
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", annotationHandler.getHeader());
        // Initialization of Viewer with document from this path
        final GroupDocsFilePath groupDocsFilePath;
        if (StringUtils.isNotEmpty(fileUrl)) {
            groupDocsFilePath = new GroupDocsFilePath(fileUrl);
        } else {
            groupDocsFilePath = new GroupDocsFilePath(fileId, annotationHandler.getConfiguration());
        }
        final String userGuid = annotationHandler.addCollaborator(userName, groupDocsFilePath.getPath(), AccessRights.All, getIntFromColor(Color.black));
        HashMap<String, String> params = new HashMap<String, String>() {{
            put("filePath", groupDocsFilePath.getPath());
            put("showHeader", Boolean.toString(applicationConfig.getShowHeader()));
            put("showThumbnails", Boolean.toString(applicationConfig.getShowThumbnails()));
            put("openThumbnails", Boolean.toString(applicationConfig.getOpenThumbnails()));
            put("width", Integer.toString(applicationConfig.getWidth()));
            put("height", Integer.toString(applicationConfig.getHeight()));
            put("showFolderBrowser", Boolean.toString(applicationConfig.getShowFolderBrowser())); // Not used
            put("showPrint", Boolean.toString(applicationConfig.getShowPrint()));
            put("showDownload", Boolean.toString(applicationConfig.getShowDownload())); // Not used
            put("showZoom", Boolean.toString(applicationConfig.getShowZoom()));
            put("showPaging", Boolean.toString(applicationConfig.getShowPaging()));
            put("showSearch", Boolean.toString(applicationConfig.getShowSearch())); // Not used
            put("userName", userName == null ? "Anonimous" : userName);
            put("userGuid", userGuid);
        }};
        model.addAttribute("groupdocsScripts", annotationHandler.getScripts(params));
        model.addAttribute("width", applicationConfig.getWidth());
        model.addAttribute("height", applicationConfig.getHeight());

        return "index";
    }

    /**
     * Get JavaScript file [GET request]
     *
     * @param script
     * @param response
     * @throws IOException
     */
    @Override
    @RequestMapping(value = GET_JS_HANDLER, method = RequestMethod.GET)
    public void getJsHandler(String script, HttpServletResponse response) throws IOException {
        annotationHandler.getJsHandler(script, response);
    }

    /**
     * Get css file [GET request]
     *
     * @param script
     * @param response
     * @throws IOException
     */
    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public void getCssHandler(String script, HttpServletResponse response) throws IOException {
        annotationHandler.getCssHandler(script, response);
    }

    /**
     * Get image file [GET request]
     *
     * @param name
     * @param response
     * @throws IOException
     */
    @Override
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getImageHandler(@PathVariable String name, HttpServletResponse response) throws IOException {
        annotationHandler.getImageHandler(name, response);
    }

    /**
     * Download file [GET request]
     *
     * @param path
     * @param response
     * @throws java.lang.Exception
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public void getFileHandler(@RequestParam("path") String path, HttpServletResponse response) throws Exception {
        annotationHandler.getFileHandler(path, response);
    }

    /**
     * Get document image files [GET request]
     *
     * @param guid
     * @param width
     * @param quality
     * @param usePdf
     * @param pageIndex
     * @throws Exception
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getDocumentPageImageHandler(@RequestParam("path") String guid, @RequestParam("width") String width, @RequestParam("quality") Integer quality,
                                            @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response) throws Exception {
        annotationHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex, response);
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

    /**
     * Get list of annotations for document [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = LIST_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object listAnnotationsHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.listAnnotationsHandler(request));
    }

    /**
     * Download document with annotations [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = EXPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object exportAnnotationsHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.exportAnnotationsHandler(request));
    }

    /**
     * Download document as PDF file [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_VERSION_OF_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public Object getPdfVersionOfDocumentHandler(HttpServletRequest request) {
        return null;
    }

    /**
     * Request to create annotation on document [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = CREATE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object createAnnotationHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.createAnnotationHandler(request));
    }

    /**
     * Get avatar for current user [GET request]
     *
     * @param request HTTP servlet request
     * @param response
     * @param userId  user id
     * @return
     */
    @RequestMapping(value = GET_AVATAR_HANDLER, method = RequestMethod.GET)
    public Object getAvatarHandler(HttpServletRequest request, HttpServletResponse response, String userId) {
        return annotationHandler.getAvatarHandler(request, response, userId);
    }

    /**
     * Add reply to annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = ADD_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object addAnnotationReplyHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.addAnnotationReplyHandler(request));
    }

    /**
     * Edit reply for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = EDIT_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object editAnnotationReplyHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.editAnnotationReplyHandler(request));
    }

    /**
     * Delete reply from annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationReplyHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.deleteAnnotationReplyHandler(request));
    }

    /**
     * Delete annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.deleteAnnotationHandler(request));
    }

    /**
     * Save text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = SAVE_TEXT_FIELD_HANDLER, method = RequestMethod.POST)
    public Object saveTextFieldHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.saveTextFieldHandler(request));
    }

    /**
     * Set color for text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = SET_TEXT_FIELD_COLOR_HANDLER, method = RequestMethod.POST)
    public Object setTextFieldColorHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.setTextFieldColorHandler(request));
    }

    /**
     * Set annotation marker position [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = MOVE_ANNOTATION_MARKER_HANDLER, method = RequestMethod.POST)
    public Object moveAnnotationMarkerHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.moveAnnotationMarkerHandler(request));
    }

    /**
     * Set new size for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @RequestMapping(value = RESIZE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    @Override
    public Object resizeAnnotationHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.resizeAnnotationHandler(request));
    }

    @RequestMapping(value = GET_DOCUMENT_COLLABORATORS_HANDLER, method = RequestMethod.POST)
    @Override
    public Object getDocumentCollaboratorsHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.getDocumentCollaboratorsHandler(request));
    }

    @RequestMapping(value = GET_FONTS, method = RequestMethod.GET)
    @Override
    public Object getFonts(@PathVariable String name, HttpServletResponse response) {
        return annotationHandler.getFonts(name, response);
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

    public int getIntFromColor(Color color){
        return getIntFromColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    public int getIntFromColor(float red, float green, float blue){
        int R = Math.round(255 * red);
        int G = Math.round(255 * green);
        int B = Math.round(255 * blue);

        R = (R << 16) & 0x00FF0000;
        G = (G << 8) & 0x0000FF00;
        B = B & 0x000000FF;

        return 0xFF000000 | R | G | B;
    }
}
