package com.groupdocs;

import com.groupdocs.annotation.common.Utils;
import static com.groupdocs.annotation.common.Utils.toJson;
import com.groupdocs.annotation.domain.response.StatusResult;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.localization.ILocalization;
import com.groupdocs.annotation.localization.LocalizationRU;
import com.groupdocs.localization.LocalizationGE;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;
import org.atmosphere.cpr.AtmosphereResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Date: 05.12.13
 */
@Controller
public class HomeController extends HomeControllerBase {

    /**
     * Home page request with parameters
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) String file, @RequestParam(value = "tokenId", required = false) String tokenId, @RequestParam(value = "userName", required = false) final String userName) throws Exception {
        // Configure localization
        ILocalization localization = null;
        if ("RU".equalsIgnoreCase(applicationConfig.getLocalization())) {
            localization = new LocalizationRU();
        } else if ("GE".equalsIgnoreCase(applicationConfig.getLocalization())) {
            localization = new LocalizationGE();
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", annotationHandler().getHeader(applicationConfig.getApplicationPath(), request));

        // Initialization of Viewer with document from this path
        GroupDocsPath path = null;
        if (file != null && !file.isEmpty()) {
            ServiceConfiguration configuration = annotationHandler().getConfiguration();
            if (configuration != null) {
                path = new EncodedPath(file, configuration);
            }
        } else if (tokenId != null && !tokenId.isEmpty()) {
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncryptionKey());
            if (!tki.isExpired()) {
                path = tki;
            }
        }else{
            ServiceConfiguration configuration = annotationHandler().getConfiguration();
            path = new EncodedPath("GroupDocs_Demo.doc", configuration);
        }
        final String initialPath = (path == null) ? "" : path.getPath();
        final String userGuid = annotationHandler().getUserGuid(userName);
//        if (annotationHandler().getUserAvatar(userGuid) == null){
//            FileInputStream testAvatar = new FileInputStream(new File("E:\\Images\\333.jpeg"));
//            byte[] bytes = new byte[testAvatar.available()];
//            IOUtils.readFully(testAvatar, bytes);
//            Utils.closeStreams(testAvatar);
//            annotationHandler().setUserAvatar(userGuid, bytes);
//        }
        model.addAttribute("groupdocsScripts", annotationHandler().getAnnotationScript(initialPath, userName, userGuid, localization));
        return "index";
    }

    /**
     * Get JavaScript file [GET request]
     *
     * @param script   JavaScript name
     * @param response http servlet response
     * @return JavaScript file content
     * @deprecated Use method getJsHandler(String script, HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    @Deprecated
    public Object getJsHandler(String script, HttpServletResponse response) {
        writeOutput(annotationHandler().getJsHandler(script, response), response);
        return null;
    }

    /**
     * Get JavaScript file [GET request]
     *
     * @param script   JavaScript name
     * @param request  HTTP servlet request
     * @param response http servlet response
     * @return JavaScript file content
     */
    @RequestMapping(value = GET_JS_HANDLER, method = RequestMethod.GET)
    public Object getJsHandler(String script, HttpServletRequest request, HttpServletResponse response) {
        long dateSince = request.getDateHeader("If-Modified-Since");
        if (annotationHandler().isResourceModified(dateSince)) {
            response.setDateHeader("Last-Modified", AnnotationHandler.LAST_RESOURCE_MODIFIED);
            writeOutput(annotationHandler().getJsHandler(script, response), response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return null;
    }

    /**
     * Get css file [GET request]
     *
     * @param script   CSS name
     * @param response http servlet response
     * @return CSS file content
     * @deprecated Use method getCssHandler(String script, HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    @Deprecated
    public Object getCssHandler(String script, HttpServletResponse response) {
        writeOutput(annotationHandler().getCssHandler(script, response), response);
        return null;
    }

    /**
     * Get css file [GET request]
     *
     * @param script   CSS name
     * @param request  HTTP servlet request
     * @param response http servlet response
     * @return CSS file content
     */
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public Object getCssHandler(String script, HttpServletRequest request, HttpServletResponse response) {
        long dateSince = request.getDateHeader("If-Modified-Since");
        if (annotationHandler().isResourceModified(dateSince)) {
            response.setDateHeader("Last-Modified", AnnotationHandler.LAST_RESOURCE_MODIFIED);
            writeOutput(annotationHandler().getCssHandler(script, response), response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return null;
    }

    /**
     * Get image file [GET request]
     *
     * @param name     image name
     * @param response http servlet response
     * @return image content
     * @deprecated Use method getImageHandler(@PathVariable String name, HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    @Deprecated
    public Object getImageHandler(@PathVariable String name, HttpServletResponse response) {
        writeOutput(annotationHandler().getImageHandler(name, response), response);
        return null;
    }

    /**
     * Get image file [GET request]
     *
     * @param name     image name
     * @param request  HTTP servlet request
     * @param response http servlet response
     * @return image content
     */
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getImageHandler(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) {
        long dateSince = request.getDateHeader("If-Modified-Since");
        if (annotationHandler().isResourceModified(dateSince)) {
            response.setDateHeader("Last-Modified", AnnotationHandler.LAST_RESOURCE_MODIFIED);
            writeOutput(annotationHandler().getImageHandler(name, response), response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return null;
    }

    /**
     * Get font file
     *
     * @param name     font name
     * @param response http servlet response
     * @return font content
     * @deprecated Use method getFontHandler(@PathVariable String name, HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    @Deprecated
    public Object getFontHandler(@PathVariable String name, HttpServletResponse response) {
        writeOutput(annotationHandler().getFontHandler(name, response), response);
        return null;
    }

    /**
     * Get font file
     *
     * @param name     font name
     * @param request  HTTP servlet request
     * @param response http servlet response
     * @return font content
     */
    @RequestMapping(value = GET_FONT_HANDLER, method = RequestMethod.GET)
    public Object getFontHandler(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) {
        long dateSince = request.getDateHeader("If-Modified-Since");
        if (annotationHandler().isResourceModified(dateSince)) {
            response.setDateHeader("Last-Modified", AnnotationHandler.LAST_RESOURCE_MODIFIED);
            writeOutput(annotationHandler().getFontHandler(name, response), response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
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
    public Object getHtmlResourcesHandler(String filePath, HttpServletResponse response) {
        writeOutput(annotationHandler().getHtmlResourcesHandler(filePath, response), response);
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

    @Override
    @RequestMapping(value = ROTATE_PAGE_HANDLER, method = RequestMethod.POST)
    public Object rotatePageHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(annotationHandler().rotatePageHandler(request, response));
    }

    /**
     * Get list of annotations for document [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = LIST_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object listAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().listAnnotationsHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Download document with annotations [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = EXPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public Object exportAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().exportAnnotationsHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Download document as PDF file [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = GET_PDF_VERSION_OF_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public Object getPdfVersionOfDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().getPdfVersionOfDocumentHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Request to create annotation on document [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = CREATE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object createAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().createAnnotationHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return writeOutputJson(toJson(new StatusResult(false, e.getMessage())));
        }
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
        try {
            return annotationHandler().getAvatarHandler(request, response, userId);
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Add reply to annotation [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = ADD_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object addAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().addAnnotationReplyHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Edit reply for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = EDIT_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object editAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().editAnnotationReplyHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Delete reply from annotation [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_REPLY_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationReplyHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().deleteAnnotationReplyHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Delete annotation [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = DELETE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    public Object deleteAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().deleteAnnotationHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Save text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = SAVE_TEXT_FIELD_HANDLER, method = RequestMethod.POST)
    public Object saveTextFieldHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().saveTextFieldHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Set color for text field annotation [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = SET_TEXT_FIELD_COLOR_HANDLER, method = RequestMethod.POST)
    public Object setTextFieldColorHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().setTextFieldColorHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Set annotation marker position [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @Override
    @RequestMapping(value = MOVE_ANNOTATION_MARKER_HANDLER, method = RequestMethod.POST)
    public Object moveAnnotationMarkerHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().moveAnnotationMarkerHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Set new size for annotation [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return response object
     */
    @RequestMapping(value = RESIZE_ANNOTATION_HANDLER, method = RequestMethod.POST)
    @Override
    public Object resizeAnnotationHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().resizeAnnotationHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Return list of collaborators [POST request]
     *
     * @param request HTTP servlet request
     * @param response
     * @return object with response parameters
     */
    @RequestMapping(value = GET_DOCUMENT_COLLABORATORS_HANDLER, method = RequestMethod.POST)
    @Override
    public Object getDocumentCollaboratorsHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().getDocumentCollaboratorsHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    /**
     * Upload file to GroupDocs.Annotation [POST request]
     *
     * @param userId
     * @param fld      action
     * @param fileName
     * @param multiple
     * @param request  http request
     * @param response http response
     * @return token id as json
     */
    @RequestMapping(value = UPLOAD_FILE_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> uploadFileHandler(@RequestParam("user_id") String userId, @RequestParam("fld") String fld, @RequestParam("fileName") String fileName, @RequestParam("multiple") boolean multiple, HttpServletRequest request, HttpServletResponse response) {
        try {
            if(multiple){
                return writeOutputJson(annotationHandler().uploadFileHandler(fileName, request.getInputStream()));
            }else{
                return null;
            }
        } catch (IOException | AnnotationException e) {
            Utils.log(HomeController.class, e);
            return writeOutputJson(toJson(new StatusResult(false, e.getMessage())));
        }
    }

    /**
     * @param request  http servlet request
     * @param response http servlet response
     * @return object with response parameters
     * @see com.groupdocs.annotation.handler.IGroupDocsAnnotation
     */
    @Override
    @RequestMapping(value = IMPORT_ANNOTATIONS_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> importAnnotationsHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().importAnnotationsHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return writeOutputJson(toJson(new StatusResult(false, e.getMessage())));
        }
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
        try {
            return writeOutputJson(annotationHandler().getPrintViewHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return writeOutputJson(toJson(new StatusResult(false, e.getMessage())));
        }
    }

    @Override
    @RequestMapping(value = GET_PRINT_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getPrintDocumentPageImageHandler(@RequestParam("path") String guid, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response) {
        try {
            writeOutput(annotationHandler().getPrintDocumentPageImageHandler(guid, pageIndex, response), response);
            return null;
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
    }

    @Override
    @RequestMapping(value = RESTORE_ANNOTATION_REPLIES_HANDLER, method = RequestMethod.POST)
    public Object restoreAnnotationRepliesHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            return writeOutputJson(annotationHandler().restoreAnnotationRepliesHandler(request, response));
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
            return toJson(new StatusResult(false, e.getMessage()));
        }
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
        try {
            annotationHandler().onAtmosphereReady(resource);
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
        }
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
        try {
            annotationHandler().onAtmosphereMessage(resource);
        } catch (AnnotationException e) {
            Utils.log(HomeController.class, e);
        }
    }
}
