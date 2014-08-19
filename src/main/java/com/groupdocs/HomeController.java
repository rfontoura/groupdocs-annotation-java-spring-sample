package com.groupdocs;

import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.annotation.domain.response.StatusResponse;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;
import org.atmosphere.cpr.AtmosphereResource;
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
import java.util.Map;

/**
 * Date: 05.12.13
 */
@Controller
public class HomeController extends HomeControllerBase {

    /**
     * Home page request
     *
     * @param model    view model
     * @param request  HTTP servlet request
     * @param response http servlet response
     * @param userName user name
     * @return rendered page
     * @throws Exception
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "userName", required = false) String userName) throws Exception {
        return index(model, request, response, "GroupDocs_Demo.doc", null, userName);
    }

    /**
     * Request with parameters
     *
     * @param model    view model
     * @param request  HTTP servlet request
     * @param response http servlet response
     * @param file     file name
     * @param tokenId  file token id
     * @param userName user name
     * @return rendered page
     * @throws Exception
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) String file, @RequestParam(value = "tokenId", required = false) String tokenId, @RequestParam(value = "userName", required = false) final String userName) throws Exception {
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", annotationHandler().getHeader(applicationConfig.getApplicationPath()));
        // Initialization of Viewer with document from this path
        GroupDocsPath path = null;
        if (file != null && !file.isEmpty()) {
            path = new EncodedPath(file, annotationHandler().getConfiguration());
        } else if (tokenId != null && !tokenId.isEmpty()) {
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncryptionKey());
            if (!tki.isExpired()) {
                path = tki;
            }
        }
        final String initialPath = (path == null) ? "" : path.getPath();
        final String userGuid = annotationHandler().addCollaborator(
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
//        if (annotationHandler().getUserAvatar(userGuid) == null){
//            FileInputStream testAvatar = new FileInputStream(new File("E:\\Images\\333.jpeg"));
//            byte[] bytes = new byte[testAvatar.available()];
//            IOUtils.readFully(testAvatar, bytes);
//            Utils.closeStreams(testAvatar);
//            annotationHandler().setUserAvatar(userGuid, bytes);
//        }
        model.addAttribute("groupdocsScripts", annotationHandler().getAnnotationScript(initialPath, userName, userGuid));
        return "index";
    }

    /**
     * Get JavaScript file [GET request]
     *
     * @param script   JavaScript name
     * @param response http servlet response
     * @return JavaScript file content
     */
    @Override
    @RequestMapping(value = GET_JS_HANDLER, method = RequestMethod.GET)
    public Object getJsHandler(String script, HttpServletResponse response) {
        writeOutput(annotationHandler().getJsHandler(script, response), response);
        return null;
    }

    /**
     * Get css file [GET request]
     *
     * @param script   CSS name
     * @param response http servlet response
     * @return CSS file content
     */
    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public Object getCssHandler(String script, HttpServletResponse response) {
        writeOutput(annotationHandler().getCssHandler(script, response), response);
        return null;
    }

    /**
     * Get image file [GET request]
     *
     * @param name     image name
     * @param response http servlet response
     * @return image content
     */
    @Override
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getImageHandler(@PathVariable String name, HttpServletResponse response) {
        writeOutput(annotationHandler().getImageHandler(name, response), response);
        return null;
    }

    /**
     * Get font file
     *
     * @param name     font name
     * @param response http servlet response
     * @return font content
     */
    @Override
    @RequestMapping(value = GET_FONT_HANDLER, method = RequestMethod.GET)
    public Object getFontHandler(@PathVariable String name, HttpServletResponse response) {
        writeOutput(annotationHandler().getFontHandler(name, response), response);
        return null;
    }

    /**
     * Get HTML resources
     *
     * @param filePath resource path
     * @param response http servlet response
     * @return return HTML resources
     */
    @Override
    @RequestMapping(value = GET_HTML_RESOURCES_HANDLER, method = RequestMethod.GET)
    public Object getHtmlRecoucesHandler(String filePath, HttpServletResponse response) {
        writeOutput(annotationHandler().getHtmlRecoucesHandler(filePath, response), response);
        return null;
    }

    /**
     * Download file [GET request]
     *
     * @param path     file path
     * @param getPdf   get pdf file
     * @param response http servlet response
     * @return file content
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public Object getFileHandler(@RequestParam("path") String path, @RequestParam(value = "getPdf", required = false) boolean getPdf, HttpServletResponse response) {
        writeOutput(annotationHandler().getFileHandler(path, getPdf, response), response);
        return null;
    }

    /**
     * Get document image files [GET request]
     *
     * @param guid      file guid
     * @param width     file width
     * @param quality   quality
     * @param usePdf    use PDF format
     * @param pageIndex index of page
     * @param response  http servlet response
     * @return null
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getDocumentPageImageHandler(@RequestParam("path") String guid, @RequestParam("width") Integer width, @RequestParam("quality") Integer quality,
                                              @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response) {
        writeOutput(annotationHandler().getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex, response), response);
        return null;
    }

    /**
     * Generate list of images/pages [POST request]
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().viewDocumentHandler(request, response));
    }

    /**
     * Generate list of images/pages [GET request]
     *
     * @param callback callback
     * @param data     request data
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().viewDocumentHandler(callback, data, request, response));
    }

    /**
     * Load tree of files from base directory [POST request]
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return files tree data
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().loadFileBrowserTreeDataHandler(request, response));
    }

    /**
     * Load tree of files from base directory [GET request]
     *
     * @param callback callback
     * @param data     request data
     * @param response HTTP servlet response
     * @return files tree data
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().loadFileBrowserTreeDataHandler(callback, data, response));
    }

    /**
     * Get thumbs and other images files [POST request]
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getImageUrlsHandler(request, response));
    }

    /**
     * Get thumbs and other images files [GET request]
     *
     * @param callback callback
     * @param data     request data
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getImageUrlsHandler(callback, data, request, response));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @Deprecated
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getPdf2JavaScriptHandler(request, response));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     *
     * @param callback callback
     * @param data     request data
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @Deprecated
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getPdf2JavaScriptHandler(callback, data, response));
    }

    /**
     * Print document [POST request]
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutput(annotationHandler().getPrintableHtmlHandler(request, response), MediaType.TEXT_HTML);
    }

    /**
     * Print document [GET request]
     *
     * @param callback callback
     * @param data     request data
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getPrintableHtmlHandler(callback, data, request, response));
    }

    /**
     * Get document content as html
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response data
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_HTML_HANDLER, method = RequestMethod.GET)
    public Object getDocumentPageHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        writeOutput(annotationHandler().getDocumentPageHtmlHandler(request, response), response);
        return null;
    }

    /**
     * Get data for print dialog
     *
     * @param path     file path
     * @param response HTTP servlet response
     * @return response object
     * @see com.groupdocs.annotation.handler.AnnotationHandler
     */
    @Override
    @RequestMapping(value = GET_PDF_WITH_PRINT_DIALOG, method = RequestMethod.GET)
    public Object getPdfWithPrintDialog(String path, HttpServletResponse response) {
        writeOutput(annotationHandler().getPdfWithPrintDialog(path, response), response);
        return null;
    }

    /**
     * Reorder page
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response data
     * @see com.groupdocs.annotation.handler.AnnotationHandler
     */
    @Override
    @RequestMapping(value = REORDER_PAGE_HANDLER, method = RequestMethod.POST)
    public Object reorderPageHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().reorderPageHandler(request, response));
    }

    /**
     * Get list of annotations for document [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = LIST_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object listAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().listAnnotationsHandler(request, response));
    }

    /**
     * Download document with annotations [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = EXPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object exportAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().exportAnnotationsHandler(request, response));
    }

    /**
     * Download document as PDF file [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = GET_PDF_VERSION_OF_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public Object getPdfVersionOfDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getPdfVersionOfDocumentHandler(request, response));
    }

    /**
     * Request to create annotation on document [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = CREATE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object createAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().createAnnotationHandler(request, response));
    }

    /**
     * Get avatar for current user [GET request]
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @param userId   user id
     * @return response object
     */
    @RequestMapping(value = GET_AVATAR_HANDLER, method = RequestMethod.GET)
    @Override
    public Object getAvatarHandler(HttpServletRequest request, HttpServletResponse response, String userId) {
        return annotationHandler().getAvatarHandler(request, response, userId);
    }

    /**
     * Add reply to annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = ADD_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object addAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().addAnnotationReplyHandler(request, response));
    }

    /**
     * Edit reply for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = EDIT_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object editAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().editAnnotationReplyHandler(request, response));
    }

    /**
     * Delete reply from annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().deleteAnnotationReplyHandler(request, response));
    }

    /**
     * Delete annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().deleteAnnotationHandler(request, response));
    }

    /**
     * Save text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = SAVE_TEXT_FIELD_HANDLER, method = RequestMethod.POST)
    public Object saveTextFieldHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().saveTextFieldHandler(request, response));
    }

    /**
     * Set color for text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = SET_TEXT_FIELD_COLOR_HANDLER, method = RequestMethod.POST)
    public Object setTextFieldColorHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().setTextFieldColorHandler(request, response));
    }

    /**
     * Set annotation marker position [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @Override
    @RequestMapping(value = MOVE_ANNOTATION_MARKER_HANDLER, method = RequestMethod.POST)
    public Object moveAnnotationMarkerHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().moveAnnotationMarkerHandler(request, response));
    }

    /**
     * Set new size for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @return response object
     */
    @RequestMapping(value = RESIZE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    @Override
    public Object resizeAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().resizeAnnotationHandler(request, response));
    }

    /**
     * Return list of collaborators [POST request]
     *
     * @param request HTTP servlet request
     * @return object with response parameters
     */
    @RequestMapping(value = GET_DOCUMENT_COLLABORATORS_HANDLER, method = RequestMethod.POST)
    @Override
    public Object getDocumentCollaboratorsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getDocumentCollaboratorsHandler(request, response));
    }

    /**
     * Upload file to GroupDocs.Annotation [POST request]
     *
     * @param fld      action
     * @param request  http request
     * @param response http response
     * @return token id as json
     */
    @RequestMapping(value = UPLOAD_FILE_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> uploadFileHandler(@RequestParam("user_id") String userId, @RequestParam("fld") String fld, HttpServletRequest request, HttpServletResponse response) {
        String uploadFileName = null;
        InputStream uploadInputStream = null;
        if (request instanceof DefaultMultipartHttpServletRequest) {
            Map<String, MultipartFile> fileMap = ((DefaultMultipartHttpServletRequest) request).getFileMap();
            if (fileMap.keySet().iterator().hasNext()) {
                String fileName = fileMap.keySet().iterator().next();
                MultipartFile multipartFile = fileMap.get(fileName);
                uploadFileName = multipartFile.getOriginalFilename();
                try {
                    uploadInputStream = multipartFile.getInputStream();
                } catch (IOException e) {
                    return writeOutputJson(new StatusResponse(false, "Can't get input stream!"));
                }
            }
        }
        return writeOutputJson(annotationHandler().uploadFileHandler(userId, uploadFileName, uploadInputStream, true));
    }

    /**
     * @param request  http servlet request
     * @param response http servlet response
     * @return object with response parameters
     * @see com.groupdocs.annotation.handler.GroupDocsAnnotation
     */
    @Override
    @RequestMapping(value = IMPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> importAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().importAnnotationsHandler(request, response));
    }

    /**
     * Get view for print document
     *
     * @param request  HTTP servlet request
     * @param response HTTP servlet response
     * @return response object
     */
    @Override
    @RequestMapping(value = GET_PRINT_VIEW_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintViewHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().getPrintViewHandler(request, response));
    }

    /**
     * On ready handler
     *
     * @param resource resource data received from socket
     */
    @Override
    @ResponseBody
    @RequestMapping(value = ATMOSPHERE_ANNOTATION, method = RequestMethod.GET)
    public void onAtmosphereReady(AtmosphereResource resource) {
        annotationHandler().onAtmosphereReady(resource);
    }

    /**
     * On message handler [POST]
     *
     * @param resource resource data received from socket
     */
    @Override
    @ResponseBody
    @RequestMapping(value = ATMOSPHERE_ANNOTATION, method = RequestMethod.POST)
    public void onAtmosphereMessage(AtmosphereResource resource) {
        annotationHandler().onAtmosphereMessage(resource);
    }
}
