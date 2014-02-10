package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.annotation.config.ServiceConfiguration;
import com.groupdocs.annotation.domain.Assets;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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
        return index(model, request, response, "/files/GroupDocs_Demo.doc", null);
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

    /**
     * Download file [GET request]
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
     * Get image file [GET request]
     * @param guid
     * @param width
     * @param quality
     * @param usePdf
     * @param pageIndex
     * @throws Exception
     */
    @Override
    @RequestMapping(value = DOCUMENT_VIEWER + GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
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
    @RequestMapping(value = DOCUMENT_VIEWER + VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
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
    @RequestMapping(value = DOCUMENT_VIEWER + LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
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
    @RequestMapping(value = DOCUMENT_VIEWER + GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
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
    @RequestMapping(value = LIST_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object listAnnotationsHandler(HttpServletRequest request) {
        return jsonOut(annotationHandler.listAnnotationsHandler(request));
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
        return jsonOut(annotationHandler.createAnnotationHandler(request));
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
        return jsonOut(annotationHandler.deleteAnnotationHandler(request));
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

    @RequestMapping(value = "/signalr1_1_2/hubs", method = RequestMethod.GET)
    public Object signalRHubs(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/javascript; charset=UTF-8");
        response.getOutputStream().write("(function(e,t){\"use strict\";function r(t,n){return function(){n.apply(t,e.makeArray(arguments))}}function i(t,n){var i,s,o,u,a;for(i in t){if(t.hasOwnProperty(i)){s=t[i];if(!s.hubName){continue}if(n){a=s.on}else{a=s.off}for(o in s.client){if(s.client.hasOwnProperty(o)){u=s.client[o];if(!e.isFunction(u)){continue}a.call(s,o,r(s,u))}}}}}if(typeof e.signalR!==\"function\"){throw new Error(\"SignalR: SignalR is not loaded. Please ensure jquery.signalR-x.js is referenced before ~/signalr/hubs.\")}var n=e.signalR;e.hubConnection.prototype.createHubProxies=function(){var t={};this.starting(function(){i(t,true);this._registerSubscribedHubs()}).disconnected(function(){i(t,false)});t.annotationHub=this.createHubProxy(\"annotationHub\");t.annotationHub.client={};t.annotationHub.server={broadcastDocumentScale:function(n,r,i,s){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastDocumentScale\"],e.makeArray(arguments)))},broadcastDocumentScroll:function(n,r,i,s,o,u){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastDocumentScroll\"],e.makeArray(arguments)))},broadcastMouseCursorPosition:function(n,r,i,s,o,u,a){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastMouseCursorPosition\"],e.makeArray(arguments)))},broadcastSlaveConnected:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastSlaveConnected\"],e.makeArray(arguments)))},getClient:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"GetClient\"],e.makeArray(arguments)))},getConnectionIdsToCall:function(n,r){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"GetConnectionIdsToCall\"],e.makeArray(arguments)))},getConnectionUser:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"GetConnectionUser\"],e.makeArray(arguments)))},setDocumentGuidForConnection:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"SetDocumentGuidForConnection\"],e.makeArray(arguments)))},setUserGuidForConnection:function(n,r){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"SetUserGuidForConnection\"],e.makeArray(arguments)))}};return t};n.hub=e.hubConnection(\"/signalr1_1_2\",{useDefaultPath:false});e.extend(n,n.hub.createHubProxies())})(window.jQuery,window)".getBytes());
        response.getOutputStream().close();
        return null;
    }

    @RequestMapping(value = "/signalr1_1_2/negotiate", method = RequestMethod.GET)
    public Object signalRNegotiate(HttpServletRequest request, HttpServletResponse response, String _, String uid) throws IOException{
        response.setContentType("application/json; charset=UTF-8");
        response.getOutputStream().write("{\"Url\":\"/signalr1_1_2/hubs\",\"ConnectionToken\":\"kZjUv3VPwqPPpQN3aUMennONGXyq49GNDDsEgslCqwkaZ4a7sto3Fr4A8-IJ474bjnPZwKrM2S3XvuGA-j2LDQla3gfX5wYUYyZ2uNjsa_aXO4SP2gdkXs0yEDLMHH9eUUo4Ii81xuCQWqqYjFTJNoTdmkvwiF_HcDK2LlRDVJsfjsf0H2gXpodU88r7ENl80\",\"ConnectionId\":\"dbc14300-0a4b-46ce-be3d-0e9cd06a8af3\",\"KeepAliveTimeout\":200.0,\"DisconnectTimeout\":300.0,\"TryWebSockets\":false,\"WebSocketServerUrl\":null,\"ProtocolVersion\":\"1.2\"}".getBytes());
        response.getOutputStream().close();
        return null;
    }

    @RequestMapping(value = "/signalr1_1_2/hubs/connect", method = RequestMethod.GET)
    public Object signalRHubsConnect(HttpServletRequest request, HttpServletResponse response, String transport, String connectionToken, String connectionData, String uid, String tid) throws IOException{
        response.setContentType("text/event-stream");
        boolean initialized = false;
        InputStream inputStream = request.getInputStream();
        OutputStream outputStream = response.getOutputStream();
        while(true){
            if (!initialized)
            {
                outputStream.write("data: initialized\n\n".getBytes());
                outputStream.flush();
                initialized = true;
            }
            if (inputStream.available() > 0) {
                String inputData = new DataInputStream(inputStream).readUTF();
                System.out.println(inputData);
            }
            try { Thread.sleep(100); } catch (Exception e){}
        }
    }

    @RequestMapping(value = "/signalr1_1_2/hubs/reconnect", method = RequestMethod.GET)
    public Object signalRHubsReconnect(HttpServletRequest request, HttpServletResponse response, String transport, String connectionToken, String connectionData, String uid, String tid) throws IOException{
        return signalRHubsConnect(request, response, transport, connectionToken, connectionData, uid, tid);
    }

    @RequestMapping(value = "/signalr1_1_2/hubs/ping", method = RequestMethod.GET)
    public Object signalRHubsPing(HttpServletRequest request, HttpServletResponse response, String uid, String _) throws IOException{
        return null;
    }

    @RequestMapping(value = "/signalr1_1_2/send", method = RequestMethod.POST)
    public Object signalRHubsSend(HttpServletRequest request, HttpServletResponse response, String transport, String connectionToken, String uid) throws IOException{
        response.setContentType("application/json; charset=UTF-8");
        response.getOutputStream().write("{\"I\":\"0\"}".getBytes());
        response.getOutputStream().close();
        return null;
    }

    @RequestMapping(value = "/signalr1_1_2/abort", method = RequestMethod.POST)
    public Object signalRHubsAbort(HttpServletRequest request, HttpServletResponse response, String transport, String connectionToken, String uid) throws IOException{
        response.getOutputStream().close();
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
