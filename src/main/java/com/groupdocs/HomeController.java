package com.groupdocs;

import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.annotation.domain.response.StatusResponse;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.handler.GroupDocsAnnotation;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class HomeController extends GroupDocsAnnotation {
    @Autowired
    protected ApplicationConfig applicationConfig;
    protected AnnotationHandler annotationHandler = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "userName", required = false) String userName) throws Exception {
        return index(model, request, response, null, null, "/files/GroupDocs_Demo.doc", null, userName);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fileId", required = false) String fileId, @RequestParam(value = "fileUrl", required = false) String fileUrl, @RequestParam(value = "filePath", required = false) String filePath, @RequestParam(value = "tokenId", required = false) String tokenId, @RequestParam(value = "userName", required = false) final String userName) throws Exception {
        if (annotationHandler == null) {
            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Vilnius"));
            ServiceConfiguration serviceConfiguration = new ServiceConfiguration(applicationConfig);
            annotationHandler = new AnnotationHandler(serviceConfiguration);
//            annotationHandler = new AnnotationHandler(config, new CustomInputDataHandler(config));
//            InputDataHandler.setInputDataHandler(new CustomInputDataHandler(config));
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", annotationHandler.getHeader(request));
        // Initialization of Viewer with document from this path
        final GroupDocsPath groupDocsFilePath;

        if(fileId !=null && !fileId.isEmpty()){
            groupDocsFilePath = new FileId(fileId);
        }else if(filePath != null && !filePath.isEmpty()){
            groupDocsFilePath = new FilePath(filePath, annotationHandler.getConfiguration());
        }else if(fileUrl != null && !fileUrl.isEmpty()){
            groupDocsFilePath = new FileUrl(fileUrl);
        }else if(tokenId != null && !tokenId.isEmpty()){
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncryptionKey());
            if(tki.isExpired()){
                groupDocsFilePath = null;
            }else{
                groupDocsFilePath = tki;
            }
        } else {
            groupDocsFilePath = null;
        }
        final String userGuid = annotationHandler.addCollaborator(
                userName,
                groupDocsFilePath.getPath(),
                AccessRights.from(
                        AccessRights.CAN_VIEW,
                        AccessRights.CAN_ANNOTATE,
                        AccessRights.CAN_EXPORT,
                        AccessRights.CAN_DOWNLOAD,
                        AccessRights.CAN_DELETE
                ),
                getIntFromColor(Color.black));
        HashMap<String, Object> params = new HashMap<String, Object>() {{
            // You can skip parameters which have default value
            put("filePath",                             groupDocsFilePath.getPath()); // Default value: empty string
            put("width",                                applicationConfig.getWidth());            // Default value: 800
            put("height",                               applicationConfig.getHeight());           // Default value: 600
            put("quality",                              applicationConfig.getQuality());              // Default value: 90
            put("enableRightClickMenu",                 applicationConfig.isEnableRightClickMenu());            // Default value: true
            put("showHeader",                           applicationConfig.isShowHeader());       // Default value: true
            put("showZoom",                             applicationConfig.isShowZoom());         // Default value: true
            put("showPaging",                           applicationConfig.isShowPaging());       // Default value: true
            put("showPrint",                            applicationConfig.isShowPrint());        // Default value: false
            put("showFileExplorer",                     applicationConfig.isShowFileExplorer());            // Default value: true
            put("showThumbnails",                       applicationConfig.isShowThumbnails());   // Default value: true
            put("showToolbar",                          applicationConfig.isShowToolbar());            // Default value: true
            put("openThumbnails",                       applicationConfig.isOpenThumbnails());   // Default value: false
            put("zoomToFitWidth",                       applicationConfig.isZoomToFitWidth());           // Default value: false
            put("zoomToFitHeight",                      applicationConfig.isZoomToFitHeight());           // Default value: false
            put("initialZoom",                          applicationConfig.getInitialZoom());             // Default value: 100
            put("preloadPagesCount",                    applicationConfig.getPreloadPagesCount());               // Default value: 0
            put("enableSidePanel",                      applicationConfig.isEnableSidePanel());            // Default value: true
            put("scrollOnFocus",                        applicationConfig.isScrollOnFocus());            // Default value: true
            put("strikeOutColor",                       applicationConfig.getStrikeOutColor());                // Default value: empty string
            put("enabledTools",                         applicationConfig.getEnabledTools());            // Default value: 2047
            put("connectorPosition",                    applicationConfig.getConnectorPosition());               // Default value: 0
            put("saveReplyOnFocusLoss",                 applicationConfig.isSaveReplyOnFocusLoss());           // Default value: false
            put("clickableAnnotations",                 applicationConfig.isClickableAnnotations());           // Default value: true
            put("disconnectUncommented",                applicationConfig.isDisconnectUncommented());           // Default value: false
            put("strikeoutMode",                        applicationConfig.getStrikeoutMode());               // Default value: 0
            put("sideboarContainerSelector",            applicationConfig.getSidebarContainerSelector()); // Default value: div.comments_sidebar_wrapper
            put("usePageNumberInUrlHash",               applicationConfig.isUsePageNumberInUrlHash());           // Default value: false
            put("textSelectionSynchronousCalculation",  applicationConfig.isTextSelectionSynchronousCalculation());            // Default value: true
            put("variableHeightPageSupport",            applicationConfig.isVariableHeightPageSupport());            // Default value: true
            put("useJavaScriptDocumentDescription",     applicationConfig.isUseJavaScriptDocumentDescription());            // Default value: true
            put("isRightPanelEnabled",                  applicationConfig.isRightPanelEnabled());            // Default value: true
            put("createMarkup",                         applicationConfig.isCreateMarkup());            // Default value: true
            put("use_pdf",                              applicationConfig.isUse_pdf());            // Default value: true
            put("_mode",                                applicationConfig.getMode());           // Default value: annotatedDocument
            put("selectionContainerSelector",           applicationConfig.getSelectionContainerSelector());  // Default value: [name='selection-content']
            put("graphicsContainerSelector",            applicationConfig.getGraphicsContainerSelector());       // Default value: .annotationsContainer
            put("widgetId",                             applicationConfig.getWidgetId());           // Default value: annotation-widget
            put("userName",                             userName == null ? "Anonimous" : userName);
            put("userGuid",                             userGuid);
//            put("showFolderBrowser", applicationConfig.getShowFolderBrowser())); // Not used
//            put("showDownload", applicationConfig.getShowDownload())); // Not used
//            put("showSearch", applicationConfig.getShowSearch())); // Not used
        }};
        model.addAttribute("groupdocsScripts", annotationHandler.getScripts(request, params));
        model.addAttribute("width", applicationConfig.getWidth());   // This is for sample JSP (index.jsp)
        model.addAttribute("height", applicationConfig.getHeight()); // This is for sample JSP (index.jsp)

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

    @Override
    @RequestMapping(value = GET_FONT_HANDLER, method = RequestMethod.GET)
    public void getFontHandler(String name, HttpServletResponse response) throws IOException {
        annotationHandler.getFontHandler(name, response);
    }

    @Override
    @RequestMapping(value = GET_HTML_RESOURCES_HANDLER, method = RequestMethod.GET)
    public void getHtmlRecoucesHandler(String filePath, HttpServletResponse response) throws IOException {
        annotationHandler.getHtmlRecoucesHandler(filePath, response);
    }

    /**
     * Download file [GET request]
     * @param path file path
     * @param getPdf get pdf file
     * @param response http servlet response
     * @throws java.lang.Exception
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public void getFileHandler(@RequestParam("path") String path, @RequestParam(value = "getPdf", required = false) boolean getPdf, HttpServletResponse response) throws Exception {
        annotationHandler.getFileHandler(path, getPdf, response);
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
    public void getDocumentPageImageHandler(@RequestParam("path") String guid, @RequestParam("width") Integer width, @RequestParam("quality") Integer quality,
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
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.viewDocumentHandler(request, response));
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
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.viewDocumentHandler(callback, data, request, response));
    }

    /**
     * Load tree of files from base directory [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.loadFileBrowserTreeDataHandler(request, response));
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
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data, HttpServletResponse response) {
        return jsonOut(annotationHandler.loadFileBrowserTreeDataHandler(callback, data, response));
    }

    /**
     * Get thumbs and other images files [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.getImageUrlsHandler(request, response));
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
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.getImageUrlsHandler(callback, data, request, response));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.getPdf2JavaScriptHandler(request, response));
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
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data, HttpServletResponse response) {
        return jsonOut(annotationHandler.getPdf2JavaScriptHandler(callback, data, response));
    }

    /**
     * Print document [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        return typeOut(annotationHandler.getPrintableHtmlHandler(request, response), MediaType.TEXT_HTML);
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
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.getPrintableHtmlHandler(callback, data, request, response));
    }

    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_HTML_HANDLER, method = RequestMethod.GET)
    public void getDocumentPageHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        annotationHandler.getDocumentPageHtmlHandler(request, response);
    }

    /**
     * @see com.groupdocs.annotation.handler.AnnotationHandler
     */
    @Override
    @RequestMapping(value = GET_PDF_WITH_PRINT_DIALOG, method = RequestMethod.GET)
    public void getPdfWithPrintDialog(String path, HttpServletResponse response) {
        annotationHandler.getPdfWithPrintDialog(path, response);
    }

    /**
     * @see com.groupdocs.annotation.handler.AnnotationHandler
     */
    @Override
    @RequestMapping(value = REORDER_PAGE_HANDLER, method = RequestMethod.POST)
    public Object reorderPageHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.reorderPageHandler(request, response));
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
        return jsonOut(annotationHandler.listAnnotationsHandler(request, response));
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
        return jsonOut(annotationHandler.exportAnnotationsHandler(request, response));
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
        return jsonOut(annotationHandler.getPdfVersionOfDocumentHandler(request, response));
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
        return jsonOut(annotationHandler.createAnnotationHandler(request, response));
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
    public Object addAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.addAnnotationReplyHandler(request, response));
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
        return jsonOut(annotationHandler.editAnnotationReplyHandler(request, response));
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
        return jsonOut(annotationHandler.deleteAnnotationReplyHandler(request, response));
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
        return jsonOut(annotationHandler.deleteAnnotationHandler(request, response));
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
        return jsonOut(annotationHandler.saveTextFieldHandler(request, response));
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
        return jsonOut(annotationHandler.setTextFieldColorHandler(request, response));
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
        return jsonOut(annotationHandler.moveAnnotationMarkerHandler(request, response));
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
        return jsonOut(annotationHandler.resizeAnnotationHandler(request, response));
    }

    /**
     * Return list of collaborators [POST request]
     * @param request HTTP servlet request
     * @return object with response parameters
     */
    @RequestMapping(value = GET_DOCUMENT_COLLABORATORS_HANDLER, method = RequestMethod.POST)
    @Override
    public Object getDocumentCollaboratorsHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.getDocumentCollaboratorsHandler(request, response));
    }

    /**
     * Upload file to GroupDocs.Annotation [POST request]
     * @param fld action
     * @param request http request
     * @param response http response
     * @return token id as json
     */
    @Override
    @RequestMapping(value = UPLOAD_FILE, method = RequestMethod.POST)
    public ResponseEntity<String> uploadFileHandler(
            @RequestParam("user_id") String userId,
            @RequestParam("fld") String fld,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        if (annotationHandler == null) { return jsonOut(new StatusResponse(false, "Please, reload page!")); }

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
        return jsonOut(annotationHandler.uploadFileHandler(userId, fld, uploadFileName, uploadInputStream, 0, request, response));
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
        return jsonOut(annotationHandler.importAnnotationsHandler(request, response));
    }

    @Override
    @RequestMapping(value = GET_PRINT_VIEW_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintViewHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(annotationHandler.getPrintViewHandler(request, response));
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
