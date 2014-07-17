package com.groupdocs;

import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.annotation.domain.response.StatusResponse;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;
import org.atmosphere.cpr.AtmosphereResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Date: 05.12.13
 */
@Controller
public class HomeController extends HomeControllerBase {
    @Autowired
    protected ApplicationConfig applicationConfig;
    protected AnnotationHandler annotationHandler = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "userName", required = false) String userName) throws Exception {
        return index(model, request, response, applicationConfig.getBasePath() + "/files/GroupDocs_Demo.doc", null, userName);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) String file, @RequestParam(value = "tokenId", required = false) String tokenId, @RequestParam(value = "userName", required = false) final String userName) throws Exception {
        if (annotationHandler == null) {
            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Vilnius"));
            ServiceConfiguration serviceConfiguration = new ServiceConfiguration(applicationConfig);
            annotationHandler = new AnnotationHandler(serviceConfiguration);
//            annotationHandler = new AnnotationHandler(config, new CustomInputDataHandler(config));
//            InputDataHandler.setInputDataHandler(new CustomInputDataHandler(config));
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", annotationHandler.getHeader());
        // Initialization of Viewer with document from this path
        GroupDocsPath path = null;
        if(file != null && !file.isEmpty()){
            path = new EncodedPath(file, annotationHandler.getConfiguration());
        }else if(tokenId != null && !tokenId.isEmpty()){
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncryptionKey());
            if(!tki.isExpired()){
                path = tki;
            }
        }
        final String initialPath = (path == null) ? "" : path.getPath();
        final String userGuid = annotationHandler.addCollaborator(
                userName,
                initialPath,
                AccessRights.All,
//                AccessRights.from(
//                        AccessRights.CAN_VIEW,
//                        AccessRights.CAN_ANNOTATE,
//                        AccessRights.CAN_EXPORT,
//                        AccessRights.CAN_DOWNLOAD,
//                        AccessRights.CAN_DELETE
//                ),
                getIntFromColor(Color.black));
        model.addAttribute("groupdocsScripts", annotationHandler.getAnnotationScript(null, initialPath, userName, userGuid));
        model.addAttribute("width", applicationConfig.getWidth());   // This is for sample JSP (index.jsp)
        model.addAttribute("height", applicationConfig.getHeight()); // This is for sample JSP (index.jsp)

        return "index";
    }

    /**
     * Get JavaScript file [GET request]
     *
     * @param script
     * @param response
     * @return 
     */
    @Override
    @RequestMapping(value = GET_JS_HANDLER, method = RequestMethod.GET)
    public Object getJsHandler(String script, HttpServletResponse response){
        writeOutput(annotationHandler.getJsHandler(script, response), response);
        return null;
    }

    /**
     * Get css file [GET request]
     *
     * @param script
     * @param response
     * @return 
     */
    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public Object getCssHandler(String script, HttpServletResponse response){
        writeOutput(annotationHandler.getCssHandler(script, response), response);
        return null;
    }

    /**
     * Get image file [GET request]
     *
     * @param name
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getImageHandler(@PathVariable String name, HttpServletResponse response){
        writeOutput(annotationHandler.getImageHandler(name, response), response);
        return null;
    }

    @Override
    @RequestMapping(value = GET_FONT_HANDLER, method = RequestMethod.GET)
    public Object getFontHandler(String name, HttpServletResponse response){
        writeOutput(annotationHandler.getFontHandler(name, response), response);
        return null;
    }

    @Override
    @RequestMapping(value = GET_HTML_RESOURCES_HANDLER, method = RequestMethod.GET)
    public Object getHtmlRecoucesHandler(String filePath, HttpServletResponse response){
        writeOutput(annotationHandler.getHtmlRecoucesHandler(filePath, response), response);
        return null;
    }

    /**
     * Download file [GET request]
     * @param path file path
     * @param getPdf get pdf file
     * @param response http servlet response
     * @return 
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public Object getFileHandler(@RequestParam("path") String path, @RequestParam(value = "getPdf", required = false) boolean getPdf, HttpServletResponse response){
        writeOutput(annotationHandler.getFileHandler(path, getPdf, response), response);
        return null;
    }

    /**
     * Get document image files [GET request]
     *
     * @param guid
     * @param width
     * @param quality
     * @param usePdf
     * @param pageIndex
     * @param response
     * @return 
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getDocumentPageImageHandler(@RequestParam("path") String guid, @RequestParam("width") Integer width, @RequestParam("quality") Integer quality,
                                            @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response){
        writeOutput(annotationHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex, response), response);
        return null;
    }

    /**
     * Generate list of images/pages [POST request]
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.viewDocumentHandler(request, response));
    }

    /**
     * Generate list of images/pages [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.viewDocumentHandler(callback, data, request, response));
    }

    /**
     * Load tree of files from base directory [POST request]
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.loadFileBrowserTreeDataHandler(request, response));
    }

    /**
     * Load tree of files from base directory [GET request]
     *
     * @param callback
     * @param data
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.loadFileBrowserTreeDataHandler(callback, data, response));
    }

    /**
     * Get thumbs and other images files [POST request]
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getImageUrlsHandler(request, response));
    }

    /**
     * Get thumbs and other images files [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getImageUrlsHandler(callback, data, request, response));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getPdf2JavaScriptHandler(request, response));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     *
     * @param callback
     * @param data
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getPdf2JavaScriptHandler(callback, data, response));
    }

    /**
     * Print document [POST request]
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutput(annotationHandler.getPrintableHtmlHandler(request, response), MediaType.TEXT_HTML);
    }

    /**
     * Print document [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getPrintableHtmlHandler(callback, data, request, response));
    }

    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_HTML_HANDLER, method = RequestMethod.GET)
    public Object getDocumentPageHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        writeOutput(annotationHandler.getDocumentPageHtmlHandler(request, response), response);
        return null;
    }

    /**
     * @param path
     * @param response
     * @return 
     * @see com.groupdocs.annotation.handler.AnnotationHandler
     */
    @Override
    @RequestMapping(value = GET_PDF_WITH_PRINT_DIALOG, method = RequestMethod.GET)
    public Object getPdfWithPrintDialog(String path, HttpServletResponse response) {
        writeOutput(annotationHandler.getPdfWithPrintDialog(path, response), response);
        return null;
    }

    /**
     * @param request
     * @param response
     * @return 
     * @see com.groupdocs.annotation.handler.AnnotationHandler
     */
    @Override
    @RequestMapping(value = REORDER_PAGE_HANDLER, method = RequestMethod.POST)
    public Object reorderPageHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.reorderPageHandler(request, response));
    }

    /**
     * Get list of annotations for document [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = LIST_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object listAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.listAnnotationsHandler(request, response));
    }

    /**
     * Download document with annotations [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = EXPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object exportAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.exportAnnotationsHandler(request, response));
    }

    /**
     * Download document as PDF file [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_VERSION_OF_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public Object getPdfVersionOfDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getPdfVersionOfDocumentHandler(request, response));
    }

    /**
     * Request to create annotation on document [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = CREATE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object createAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.createAnnotationHandler(request, response));
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
    @Override
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
    public Object addAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.addAnnotationReplyHandler(request, response));
    }

    /**
     * Edit reply for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = EDIT_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object editAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.editAnnotationReplyHandler(request, response));
    }

    /**
     * Delete reply from annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.deleteAnnotationReplyHandler(request, response));
    }

    /**
     * Delete annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.deleteAnnotationHandler(request, response));
    }

    /**
     * Save text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = SAVE_TEXT_FIELD_HANDLER, method = RequestMethod.POST)
    public Object saveTextFieldHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.saveTextFieldHandler(request, response));
    }

    /**
     * Set color for text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = SET_TEXT_FIELD_COLOR_HANDLER, method = RequestMethod.POST)
    public Object setTextFieldColorHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.setTextFieldColorHandler(request, response));
    }

    /**
     * Set annotation marker position [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @Override
    @RequestMapping(value = MOVE_ANNOTATION_MARKER_HANDLER, method = RequestMethod.POST)
    public Object moveAnnotationMarkerHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.moveAnnotationMarkerHandler(request, response));
    }

    /**
     * Set new size for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return
     */
    @RequestMapping(value = RESIZE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    @Override
    public Object resizeAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.resizeAnnotationHandler(request, response));
    }

    /**
     * Return list of collaborators [POST request]
     * @param request HTTP servlet request
     * @return object with response parameters
     */
    @RequestMapping(value = GET_DOCUMENT_COLLABORATORS_HANDLER, method = RequestMethod.POST)
    @Override
    public Object getDocumentCollaboratorsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getDocumentCollaboratorsHandler(request, response));
    }

    /**
     * Upload file to GroupDocs.Annotation [POST request]
     * @param fld action
     * @param request http request
     * @param response http response
     * @return token id as json
     * @throws java.io.IOException
     */
    @Override
    @RequestMapping(value = UPLOAD_FILE_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> uploadFileHandler(
            @RequestParam("user_id") String userId,
            @RequestParam("fld") String fld,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        if (annotationHandler == null) { return writeOutputJson(new StatusResponse(false, "Please, reload page!")); }

        String uploadFileName = null;
        InputStream uploadInputStream = null;
        if (request instanceof DefaultMultipartHttpServletRequest){
            Map<String,MultipartFile> fileMap = ((DefaultMultipartHttpServletRequest)request).getFileMap();
            if (fileMap.keySet().iterator().hasNext()) {
                String fileName = fileMap.keySet().iterator().next();
                MultipartFile multipartFile = fileMap.get(fileName);
                uploadFileName = multipartFile.getOriginalFilename();
                uploadInputStream = multipartFile.getInputStream();
            }
        }
        return writeOutputJson(annotationHandler.uploadFileHandler(userId, fld, uploadFileName, uploadInputStream, 0, request, response));
    }

    /**
     * @see com.groupdocs.annotation.handler.GroupDocsAnnotation
     * @param request http servlet request
     * @param response http servlet response
     * @return object with response parameters
     */
    @Override
    @RequestMapping(value = IMPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> importAnnotationsHandler(HttpServletRequest request, HttpServletResponse response){
        return writeOutputJson(annotationHandler.importAnnotationsHandler(request, response));
    }

    @Override
    @RequestMapping(value = GET_PRINT_VIEW_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintViewHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler.getPrintViewHandler(request, response));
    }

    /**
     * On ready handler
     * @param resource resource data received from socket
     */
    @Override
    @ResponseBody
    @RequestMapping(value = ATMOSPHERE_ANNOTATION, method = RequestMethod.GET)
    public void onAtmosphereReady(AtmosphereResource resource) {
        annotationHandler.onAtmosphereReady(resource);
    }

    /**
     * On message handler [POST]
     * @param resource resource data received from socket
     */
    @Override
    @ResponseBody
    @RequestMapping(value = ATMOSPHERE_ANNOTATION, method = RequestMethod.POST)
    public void onAtmosphereMessage(AtmosphereResource resource) {
        annotationHandler.onAtmosphereMessage(resource);
    }
}
