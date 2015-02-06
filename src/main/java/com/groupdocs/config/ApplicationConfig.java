package com.groupdocs.config;

import com.groupdocs.annotation.config.ServiceConfiguration;
import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * Spring sample configuration class
 * @author Aleksey Permyakov
 */
@Component
public class ApplicationConfig extends ServiceConfiguration {
    /**
     * The License path.
     */
    @Property(key = "groupdocs.annotation.licensePath")
    protected String licensePath;
    /**
     * The Application path.
     */
    @Property(key = "groupdocs.annotation.applicationPath")
    protected String applicationPath;
    /**
     * The Base path.
     */
    @Property(key = "groupdocs.annotation.basePath")
    protected String basePath;
    /**
     * The Storage type.
     */
    @Property(key = "groupdocs.annotation.storageType")
    protected String storageType;
    /**
     * The Db server.
     */
    @Property(key = "groupdocs.annotation.dbServer")
    protected String dbServer;
    /**
     * The Db port.
     */
    @Property(key = "groupdocs.annotation.dbPort")
    protected Integer dbPort;
    /**
     * The Db name.
     */
    @Property(key = "groupdocs.annotation.dbName")
    protected String dbName;
    /**
     * The Db username.
     */
    @Property(key = "groupdocs.annotation.dbUsername")
    protected String dbUsername;
    /**
     * The Db password.
     */
    @Property(key = "groupdocs.annotation.dbPassword")
    protected String dbPassword;
    /**
     * The Storage path.
     */
    @Property(key = "groupdocs.annotation.storagePath")
    protected String storagePath;
    /**
     * The Use authorization.
     */
    @Property(key = "groupdocs.annotation.useAuthorization")
    protected Boolean useAuthorization;
    /**
     * The Use cache.
     */
    @Property(key = "groupdocs.annotation.useCache")
    protected Boolean useCache;
    /**
     * The Expiration date.
     */
    @Property(key = "groupdocs.annotation.expirationDate")
    protected Integer expirationDate;
    /**
     * The Encryption key.
     */
    @Property(key = "groupdocs.annotation.encryptionKey")
    protected String encryptionKey;
    /**
     * The Locales path.
     */
    @Property(key = "groupdocs.annotation.localesPath")
    protected String localesPath;
    /**
     * The Quality.
     */
    @Property(key = "groupdocs.annotation.quality")
    protected Integer quality;
    /**
     * The Show thumbnails.
     */
    @Property(key = "groupdocs.annotation.showThumbnails")
    protected Boolean showThumbnails;
    /**
     * The Open thumbnails.
     */
    @Property(key = "groupdocs.annotation.openThumbnails")
    protected Boolean openThumbnails;
    /**
     * The Initial zoom.
     */
    @Property(key = "groupdocs.annotation.initialZoom")
    protected Integer initialZoom;
    /**
     * The Zoom to fit width.
     */
    @Property(key = "groupdocs.annotation.zoomToFitWidth")
    protected Boolean zoomToFitWidth;
    /**
     * The Zoom to fit height.
     */
    @Property(key = "groupdocs.annotation.zoomToFitHeight")
    protected Boolean zoomToFitHeight;
    /**
     * The Width.
     */
    @Property(key = "groupdocs.annotation.width")
    protected Integer width;
    /**
     * The Height.
     */
    @Property(key = "groupdocs.annotation.height")
    protected Integer height;
    /**
     * The Show print.
     */
    @Property(key = "groupdocs.annotation.showPrint")
    protected Boolean showPrint;
    /**
     * The Show zoom.
     */
    @Property(key = "groupdocs.annotation.showZoom")
    protected Boolean showZoom;
    /**
     * The Show paging.
     */
    @Property(key = "groupdocs.annotation.showPaging")
    protected Boolean showPaging;
    /**
     * The Preload pages count.
     */
    @Property(key = "groupdocs.annotation.preloadPagesCount")
    protected Integer preloadPagesCount;
    /**
     * The Show header.
     */
    @Property(key = "groupdocs.annotation.showHeader")
    protected Boolean showHeader;
    /**
     * The Show file explorer.
     */
    @Property(key = "groupdocs.annotation.showFileExplorer")
    protected Boolean showFileExplorer;
    /**
     * The Use em scaling.
     */
    @Property(key = "groupdocs.annotation.useEmScaling")
    protected Boolean useEmScaling;
    /**
     * The Enable right click menu.
     */
    @Property(key = "groupdocs.annotation.enableRightClickMenu")
    protected Boolean enableRightClickMenu;
    /**
     * The Show toolbar.
     */
    @Property(key = "groupdocs.annotation.showToolbar")
    protected Boolean showToolbar;
    /**
     * The Enable side panel.
     */
    @Property(key = "groupdocs.annotation.enableSidePanel")
    protected Boolean enableSidePanel;
    /**
     * The Scroll on focus.
     */
    @Property(key = "groupdocs.annotation.scrollOnFocus")
    protected Boolean scrollOnFocus;
    /**
     * The Strike out color.
     */
    @Property(key = "groupdocs.annotation.strikeOutColor")
    protected String strikeOutColor;
    /**
     * The Highlight color.
     */
    @Property(key = "groupdocs.annotation.highlightColor")
    protected String highlightColor;
    /**
     * The Underline color.
     */
    @Property(key = "groupdocs.annotation.underlineColor")
    protected String underlineColor;
    /**
     * The Text field background color.
     */
    @Property(key = "groupdocs.annotation.textFieldBackgroundColor")
    protected String textFieldBackgroundColor;
    /**
     * The Tab navigation enabled.
     */
    @Property(key = "groupdocs.annotation.tabNavigationEnabled")
    protected Boolean tabNavigationEnabled;
    /**
     * The Minimum image width.
     */
    @Property(key = "groupdocs.annotation.minimumImageWidth")
    protected Integer minimumImageWidth;
    /**
     * The Area tool options pen width.
     */
    @Property(key = "groupdocs.annotation.areaToolOptionsPenWidth")
    protected Integer areaToolOptionsPenWidth;
    /**
     * The Area tool options pen color.
     */
    @Property(key = "groupdocs.annotation.areaToolOptionsPenColor")
    protected String areaToolOptionsPenColor;
    /**
     * The Area tool options pen dash style.
     */
    @Property(key = "groupdocs.annotation.areaToolOptionsPenDashStyle")
    protected Integer areaToolOptionsPenDashStyle;
    /**
     * The Area tool options brush color.
     */
    @Property(key = "groupdocs.annotation.areaToolOptionsBrushColor")
    protected String areaToolOptionsBrushColor;
    /**
     * The Polyline tool options pen width.
     */
    @Property(key = "groupdocs.annotation.polylineToolOptionsPenWidth")
    protected Integer polylineToolOptionsPenWidth;
    /**
     * The Polyline tool options pen color.
     */
    @Property(key = "groupdocs.annotation.polylineToolOptionsPenColor")
    protected String polylineToolOptionsPenColor;
    /**
     * The Polyline tool options pen dash style.
     */
    @Property(key = "groupdocs.annotation.polylineToolOptionsPenDashStyle")
    protected Integer polylineToolOptionsPenDashStyle;
    /**
     * The Polyline tool options brush color.
     */
    @Property(key = "groupdocs.annotation.polylineToolOptionsBrushColor")
    protected String polylineToolOptionsBrushColor;
    /**
     * The Arrow tool options pen width.
     */
    @Property(key = "groupdocs.annotation.arrowToolOptionsPenWidth")
    protected Integer arrowToolOptionsPenWidth;
    /**
     * The Arrow tool options pen color.
     */
    @Property(key = "groupdocs.annotation.arrowToolOptionsPenColor")
    protected String arrowToolOptionsPenColor;
    /**
     * The Arrow tool options pen dash style.
     */
    @Property(key = "groupdocs.annotation.arrowToolOptionsPenDashStyle")
    protected Integer arrowToolOptionsPenDashStyle;
    /**
     * The Arrow tool options brush color.
     */
    @Property(key = "groupdocs.annotation.arrowToolOptionsBrushColor")
    protected String arrowToolOptionsBrushColor;
    /**
     * The Pen color.
     */
    @Property(key = "groupdocs.annotation.penColor")
    protected String penColor;
    /**
     * The Pen width.
     */
    @Property(key = "groupdocs.annotation.penWidth")
    protected Integer penWidth;
    /**
     * The Pen style.
     */
    @Property(key = "groupdocs.annotation.penStyle")
    protected Integer penStyle;
    /**
     * The Enabled tools.
     */
    @Property(key = "groupdocs.annotation.enabledTools")
    protected Integer enabledTools;
    /**
     * The Connector position.
     */
    @Property(key = "groupdocs.annotation.connectorPosition")
    protected Integer connectorPosition;
    /**
     * The Save reply on focus loss.
     */
    @Property(key = "groupdocs.annotation.saveReplyOnFocusLoss")
    protected Boolean saveReplyOnFocusLoss;
    /**
     * The Clickable annotations.
     */
    @Property(key = "groupdocs.annotation.clickableAnnotations")
    protected Boolean clickableAnnotations;
    /**
     * The Disconnect uncommented.
     */
    @Property(key = "groupdocs.annotation.disconnectUncommented")
    protected Boolean disconnectUncommented;
    /**
     * The Strikeout mode.
     */
    @Property(key = "groupdocs.annotation.strikeoutMode")
    protected Integer strikeoutMode;
    /**
     * The Any tool selection.
     */
    @Property(key = "groupdocs.annotation.anyToolSelection")
    protected Boolean anyToolSelection;
    /**
     * The Sidebar container selector.
     */
    @Property(key = "groupdocs.annotation.sidebarContainerSelector")
    protected String sidebarContainerSelector;
    /**
     * The Use page number in url hash.
     */
    @Property(key = "groupdocs.annotation.usePageNumberInUrlHash")
    protected Boolean usePageNumberInUrlHash;
    /**
     * The Text selection synchronous calculation.
     */
    @Property(key = "groupdocs.annotation.textSelectionSynchronousCalculation")
    protected Boolean textSelectionSynchronousCalculation;
    /**
     * The Variable height page support.
     */
    @Property(key = "groupdocs.annotation.variableHeightPageSupport")
    protected Boolean variableHeightPageSupport;
    /**
     * The Create markup.
     */
    @Property(key = "groupdocs.annotation.createMarkup")
    protected Boolean createMarkup;
    /**
     * The Use _ pdf.
     */
    @Property(key = "groupdocs.annotation.use_pdf")
    protected Boolean use_pdf;
    /**
     * The Mode.
     */
    @Property(key = "groupdocs.annotation.mode")
    protected String mode;
    /**
     * The Selection container selector.
     */
    @Property(key = "groupdocs.annotation.selectionContainerSelector")
    protected String selectionContainerSelector;
    /**
     * The Graphics container selector.
     */
    @Property(key = "groupdocs.annotation.graphicsContainerSelector")
    protected String graphicsContainerSelector;
    /**
     * The Use browser cache.
     */
    @Property(key = "groupdocs.annotation.useBrowserCache")
    protected Boolean useBrowserCache;
    /**
     * The Widget id.
     */
    @Property(key = "groupdocs.annotation.widgetId")
    protected String widgetId;
    /**
     * The Right panel enabled.
     */
    @Property(key = "groupdocs.annotation.rightPanelEnabled")
    protected Boolean rightPanelEnabled;
    /**
     * The Max cache size.
     */
    @Property(key = "groupdocs.annotation.maxCacheSize")
    protected Long maxCacheSize;
    /**
     * The Upload path.
     */
    @Property(key = "groupdocs.annotation.uploadPath")
    protected String uploadPath;
    /**
     * The Undo enabled.
     */
    @Property(key = "groupdocs.annotation.undoEnabled")
    protected Boolean undoEnabled;
    /**
     * The Jquery file download cookie name.
     */
    @Property(key = "groupdocs.annotation.jqueryFileDownloadCookieName")
    protected String jqueryFileDownloadCookieName;
    /**
     * The Watermark font size.
     */
    @Property(key = "groupdocs.annotation.watermarkFontSize")
    protected Integer watermarkFontSize;
    /**
     * The Watermark position.
     */
    @Property(key = "groupdocs.annotation.watermarkPosition")
    protected String watermarkPosition;
    /**
     * The Watermark text.
     */
    @Property(key = "groupdocs.annotation.watermarkText")
    protected String watermarkText;
    /**
     * The Convert word documents completely.
     */
    @Property(key = "groupdocs.annotation.convertWordDocumentsCompletely")
    protected Boolean convertWordDocumentsCompletely;
    /**
     * The Ignore document absence.
     */
    @Property(key = "groupdocs.annotation.ignoreDocumentAbsence")
    protected Boolean ignoreDocumentAbsence;
    /**
     * The Preload pages on browser side.
     */
    @Property(key = "groupdocs.annotation.preloadPagesOnBrowserSide")
    protected Boolean preloadPagesOnBrowserSide;
    /**
     * The Print with watermark.
     */
    @Property(key = "groupdocs.annotation.printWithWatermark")
    protected Boolean printWithWatermark;
    /**
     * The Support page rotation.
     */
    @Property(key = "groupdocs.annotation.supportPageRotation")
    protected Boolean supportPageRotation;
    /**
     * The Store logic.
     */
    @Property(key = "groupdocs.annotation.storeLogic")
    protected String storeLogic;
    /**
     * The Print annotations.
     */
    @Property(key = "groupdocs.annotation.printAnnotations")
    protected Boolean printAnnotations;
    /**
     * The Localization.
     */
    @Property(key = "groupdocs.annotation.localization")
    protected String localization;
    /**
     * The Disable atmosphere.
     */
    @Property(key = "groupdocs.annotation.disableAtmosphere")
    protected Boolean disableAtmosphere;
    /**
     * The File display name.
     */
    @Property(key = "groupdocs.annotation.fileDisplayName")
    protected String fileDisplayName;
    /**
     * The Is case sensitive.
     */
    @Property(key = "groupdocs.annotation.isCaseSensitive")
    protected Boolean isCaseSensitive;
    /**
     * The Search for separate words.
     */
    @Property(key = "groupdocs.annotation.searchForSeparateWords")
    protected Boolean searchForSeparateWords;
    /**
     * default file name.
     */
    @Property(key = "groupdocs.annotation.defaultFileName")
    private String defaultFileName;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLicensePath() {
        return licensePath;
    }

    /**
     * Setter for property 'licensePath'.
     * @param licensePath Value to set for property 'licensePath'.
     */
    @SuppressWarnings("unused")
    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getApplicationPath() {
        return "null".equalsIgnoreCase(applicationPath) ? null : applicationPath;
    }

    /**
     * Setter for property 'applicationPath'.
     * @param applicationPath Value to set for property 'applicationPath'.
     */
    @SuppressWarnings("unused")
    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBasePath() {
        return basePath;
    }

    /**
     * Setter for property 'basePath'.
     * @param basePath Value to set for property 'basePath'.
     */
    @SuppressWarnings("unused")
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    /**
     * Getter for property 'storageType'.
     * @return Value for property 'storageType'.
     */
    public String getStorageType() {
        return storageType;
    }

    /**
     * Setter for property 'storageType'.
     * @param storageType Value to set for property 'storageType'.
     */
    @SuppressWarnings("unused")
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    /**
     * Getter for property 'dbServer'.
     * @return Value for property 'dbServer'.
     */
    public String getDbServer() {
        return dbServer;
    }

    /**
     * Setter for property 'dbServer'.
     * @param dbServer Value to set for property 'dbServer'.
     */
    @SuppressWarnings("unused")
    public void setDbServer(String dbServer) {
        this.dbServer = dbServer;
    }

    /**
     * Getter for property 'dbPort'.
     * @return Value for property 'dbPort'.
     */
    public Integer getDbPort() {
        return dbPort;
    }

    /**
     * Setter for property 'dbPort'.
     * @param dbPort Value to set for property 'dbPort'.
     */
    @SuppressWarnings("unused")
    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    /**
     * Getter for property 'dbName'.
     * @return Value for property 'dbName'.
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * Setter for property 'dbName'.
     * @param dbName Value to set for property 'dbName'.
     */
    @SuppressWarnings("unused")
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * Getter for property 'dbUsername'.
     * @return Value for property 'dbUsername'.
     */
    public String getDbUsername() {
        return dbUsername;
    }

    /**
     * Setter for property 'dbUsername'.
     * @param dbUsername Value to set for property 'dbUsername'.
     */
    @SuppressWarnings("unused")
    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    /**
     * Getter for property 'dbPassword'.
     * @return Value for property 'dbPassword'.
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * Setter for property 'dbPassword'.
     * @param dbPassword Value to set for property 'dbPassword'.
     */
    @SuppressWarnings("unused")
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    /**
     * Getter for property 'storagePath'.
     * @return Value for property 'storagePath'.
     */
    public String getStoragePath() {
        return "null".equals(storagePath) ? null : storagePath;
    }

    /**
     * Setter for property 'storagePath'.
     * @param storagePath Value to set for property 'storagePath'.
     */
    @SuppressWarnings("unused")
    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    /**
     * Getter for property 'useAuthorization'.
     * @return Value for property 'useAuthorization'.
     */
    public Boolean isUseAuthorization() {
        return useAuthorization;
    }

    /**
     * Setter for property 'useAuthorization'.
     * @param useAuthorization Value to set for property 'useAuthorization'.
     */
    @SuppressWarnings("unused")
    public void setUseAuthorization(Boolean useAuthorization) {
        this.useAuthorization = useAuthorization;
    }

    /**
     * Getter for property 'useCache'.
     * @return Value for property 'useCache'.
     */
    public Boolean isUseCache() {
        return useCache;
    }

    /**
     * Setter for property 'useCache'.
     * @param useCache Value to set for property 'useCache'.
     */
    @SuppressWarnings("unused")
    public void setUseCache(Boolean useCache) {
        this.useCache = useCache;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getExpirationDate() {
        return expirationDate;
    }

    /**
     * Setter for property 'expirationDate'.
     * @param expirationDate Value to set for property 'expirationDate'.
     */
    @SuppressWarnings("unused")
    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * Setter for property 'encryptionKey'.
     * @param encryptionKey Value to set for property 'encryptionKey'.
     */
    @SuppressWarnings("unused")
    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLocalesPath() {
        return localesPath;
    }

    /**
     * Setter for property 'localesPath'.
     * @param localesPath Value to set for property 'localesPath'.
     */
    @SuppressWarnings("unused")
    public void setLocalesPath(String localesPath) {
        this.localesPath = localesPath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getQuality() {
        return quality;
    }

    /**
     * Setter for property 'quality'.
     * @param quality Value to set for property 'quality'.
     */
    @SuppressWarnings("unused")
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    /**
     * Getter for property 'showThumbnails'.
     * @return Value for property 'showThumbnails'.
     */
    public Boolean isShowThumbnails() {
        return showThumbnails;
    }

    /**
     * Setter for property 'showThumbnails'.
     * @param showThumbnails Value to set for property 'showThumbnails'.
     */
    @SuppressWarnings("unused")
    public void setShowThumbnails(Boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    /**
     * Getter for property 'openThumbnails'.
     * @return Value for property 'openThumbnails'.
     */
    public Boolean isOpenThumbnails() {
        return openThumbnails;
    }

    /**
     * Setter for property 'openThumbnails'.
     * @param openThumbnails Value to set for property 'openThumbnails'.
     */
    @SuppressWarnings("unused")
    public void setOpenThumbnails(Boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getInitialZoom() {
        return initialZoom;
    }

    /**
     * Setter for property 'initialZoom'.
     * @param initialZoom Value to set for property 'initialZoom'.
     */
    @SuppressWarnings("unused")
    public void setInitialZoom(Integer initialZoom) {
        this.initialZoom = initialZoom;
    }

    /**
     * Getter for property 'zoomToFitWidth'.
     * @return Value for property 'zoomToFitWidth'.
     */
    public Boolean isZoomToFitWidth() {
        return zoomToFitWidth;
    }

    /**
     * Setter for property 'zoomToFitWidth'.
     * @param zoomToFitWidth Value to set for property 'zoomToFitWidth'.
     */
    @SuppressWarnings("unused")
    public void setZoomToFitWidth(Boolean zoomToFitWidth) {
        this.zoomToFitWidth = zoomToFitWidth;
    }

    /**
     * Getter for property 'zoomToFitHeight'.
     * @return Value for property 'zoomToFitHeight'.
     */
    public Boolean isZoomToFitHeight() {
        return zoomToFitHeight;
    }

    /**
     * Setter for property 'zoomToFitHeight'.
     * @param zoomToFitHeight Value to set for property 'zoomToFitHeight'.
     */
    @SuppressWarnings("unused")
    public void setZoomToFitHeight(Boolean zoomToFitHeight) {
        this.zoomToFitHeight = zoomToFitHeight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getWidth() {
        return width;
    }

    /**
     * Setter for property 'width'.
     * @param width Value to set for property 'width'.
     */
    @SuppressWarnings("unused")
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getHeight() {
        return height;
    }

    /**
     * Setter for property 'height'.
     * @param height Value to set for property 'height'.
     */
    @SuppressWarnings("unused")
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Getter for property 'showPrint'.
     * @return Value for property 'showPrint'.
     */
    public Boolean isShowPrint() {
        return showPrint;
    }

    /**
     * Setter for property 'showPrint'.
     * @param showPrint Value to set for property 'showPrint'.
     */
    @SuppressWarnings("unused")
    public void setShowPrint(Boolean showPrint) {
        this.showPrint = showPrint;
    }

    /**
     * Getter for property 'showZoom'.
     * @return Value for property 'showZoom'.
     */
    public Boolean isShowZoom() {
        return showZoom;
    }

    /**
     * Setter for property 'showZoom'.
     * @param showZoom Value to set for property 'showZoom'.
     */
    @SuppressWarnings("unused")
    public void setShowZoom(Boolean showZoom) {
        this.showZoom = showZoom;
    }

    /**
     * Getter for property 'showPaging'.
     * @return Value for property 'showPaging'.
     */
    public Boolean isShowPaging() {
        return showPaging;
    }

    /**
     * Setter for property 'showPaging'.
     * @param showPaging Value to set for property 'showPaging'.
     */
    @SuppressWarnings("unused")
    public void setShowPaging(Boolean showPaging) {
        this.showPaging = showPaging;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPreloadPagesCount() {
        return preloadPagesCount;
    }

    /**
     * Setter for property 'preloadPagesCount'.
     * @param preloadPagesCount Value to set for property 'preloadPagesCount'.
     */
    @SuppressWarnings("unused")
    public void setPreloadPagesCount(Integer preloadPagesCount) {
        this.preloadPagesCount = preloadPagesCount;
    }

    /**
     * Getter for property 'showHeader'.
     * @return Value for property 'showHeader'.
     */
    public Boolean isShowHeader() {
        return showHeader;
    }

    /**
     * Setter for property 'showHeader'.
     * @param showHeader Value to set for property 'showHeader'.
     */
    @SuppressWarnings("unused")
    public void setShowHeader(Boolean showHeader) {
        this.showHeader = showHeader;
    }

    /**
     * Getter for property 'showFileExplorer'.
     * @return Value for property 'showFileExplorer'.
     */
    public Boolean isShowFileExplorer() {
        return showFileExplorer;
    }

    /**
     * Setter for property 'showFileExplorer'.
     * @param showFileExplorer Value to set for property 'showFileExplorer'.
     */
    @SuppressWarnings("unused")
    public void setShowFileExplorer(Boolean showFileExplorer) {
        this.showFileExplorer = showFileExplorer;
    }

    /**
     * Getter for property 'useEmScaling'.
     * @return Value for property 'useEmScaling'.
     */
    public Boolean isUseEmScaling() {
        return useEmScaling;
    }

    /**
     * Setter for property 'useEmScaling'.
     * @param useEmScaling Value to set for property 'useEmScaling'.
     */
    @SuppressWarnings("unused")
    public void setUseEmScaling(Boolean useEmScaling) {
        this.useEmScaling = useEmScaling;
    }

    /**
     * Getter for property 'enableRightClickMenu'.
     * @return Value for property 'enableRightClickMenu'.
     */
    public Boolean isEnableRightClickMenu() {
        return enableRightClickMenu;
    }

    /**
     * Setter for property 'enableRightClickMenu'.
     * @param enableRightClickMenu Value to set for property 'enableRightClickMenu'.
     */
    @SuppressWarnings("unused")
    public void setEnableRightClickMenu(Boolean enableRightClickMenu) {
        this.enableRightClickMenu = enableRightClickMenu;
    }

    /**
     * Getter for property 'showToolbar'.
     * @return Value for property 'showToolbar'.
     */
    public Boolean isShowToolbar() {
        return showToolbar;
    }

    /**
     * Setter for property 'showToolbar'.
     * @param showToolbar Value to set for property 'showToolbar'.
     */
    @SuppressWarnings("unused")
    public void setShowToolbar(Boolean showToolbar) {
        this.showToolbar = showToolbar;
    }

    /**
     * Getter for property 'enableSidePanel'.
     * @return Value for property 'enableSidePanel'.
     */
    public Boolean isEnableSidePanel() {
        return enableSidePanel;
    }

    /**
     * Setter for property 'enableSidePanel'.
     * @param enableSidePanel Value to set for property 'enableSidePanel'.
     */
    @SuppressWarnings("unused")
    public void setEnableSidePanel(Boolean enableSidePanel) {
        this.enableSidePanel = enableSidePanel;
    }

    /**
     * Getter for property 'scrollOnFocus'.
     * @return Value for property 'scrollOnFocus'.
     */
    public Boolean isScrollOnFocus() {
        return scrollOnFocus;
    }

    /**
     * Setter for property 'scrollOnFocus'.
     * @param scrollOnFocus Value to set for property 'scrollOnFocus'.
     */
    @SuppressWarnings("unused")
    public void setScrollOnFocus(Boolean scrollOnFocus) {
        this.scrollOnFocus = scrollOnFocus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStrikeOutColor() {
        return strikeOutColor;
    }

    /**
     * Setter for property 'strikeOutColor'.
     * @param strikeOutColor Value to set for property 'strikeOutColor'.
     */
    @SuppressWarnings("unused")
    public void setStrikeOutColor(String strikeOutColor) {
        this.strikeOutColor = strikeOutColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHighlightColor() {
        return highlightColor;
    }

    /**
     * Setter for property 'highlightColor'.
     * @param highlightColor Value to set for property 'highlightColor'.
     */
    @SuppressWarnings("unused")
    public void setHighlightColor(String highlightColor) {
        this.highlightColor = highlightColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUnderlineColor() {
        return underlineColor;
    }

    /**
     * Setter for property 'underlineColor'.
     * @param underlineColor Value to set for property 'underlineColor'.
     */
    @SuppressWarnings("unused")
    public void setUnderlineColor(String underlineColor) {
        this.underlineColor = underlineColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTextFieldBackgroundColor() {
        return textFieldBackgroundColor;
    }

    /**
     * Setter for property 'textFieldBackgroundColor'.
     * @param textFieldBackgroundColor Value to set for property 'textFieldBackgroundColor'.
     */
    @SuppressWarnings("unused")
    public void setTextFieldBackgroundColor(String textFieldBackgroundColor) {
        this.textFieldBackgroundColor = textFieldBackgroundColor;
    }

    /**
     * Getter for property 'tabNavigationEnabled'.
     * @return Value for property 'tabNavigationEnabled'.
     */
    public Boolean isTabNavigationEnabled() {
        return tabNavigationEnabled;
    }

    /**
     * Setter for property 'tabNavigationEnabled'.
     * @param tabNavigationEnabled Value to set for property 'tabNavigationEnabled'.
     */
    @SuppressWarnings("unused")
    public void setTabNavigationEnabled(Boolean tabNavigationEnabled) {
        this.tabNavigationEnabled = tabNavigationEnabled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getMinimumImageWidth() {
        return minimumImageWidth;
    }

    /**
     * Setter for property 'minimumImageWidth'.
     * @param minimumImageWidth Value to set for property 'minimumImageWidth'.
     */
    @SuppressWarnings("unused")
    public void setMinimumImageWidth(Integer minimumImageWidth) {
        this.minimumImageWidth = minimumImageWidth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getAreaToolOptionsPenWidth() {
        return areaToolOptionsPenWidth;
    }

    /**
     * Setter for property 'areaToolOptionsPenWidth'.
     * @param areaToolOptionsPenWidth Value to set for property 'areaToolOptionsPenWidth'.
     */
    @SuppressWarnings("unused")
    public void setAreaToolOptionsPenWidth(Integer areaToolOptionsPenWidth) {
        this.areaToolOptionsPenWidth = areaToolOptionsPenWidth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAreaToolOptionsPenColor() {
        return areaToolOptionsPenColor;
    }

    /**
     * Setter for property 'areaToolOptionsPenColor'.
     * @param areaToolOptionsPenColor Value to set for property 'areaToolOptionsPenColor'.
     */
    @SuppressWarnings("unused")
    public void setAreaToolOptionsPenColor(String areaToolOptionsPenColor) {
        this.areaToolOptionsPenColor = areaToolOptionsPenColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getAreaToolOptionsPenDashStyle() {
        return areaToolOptionsPenDashStyle;
    }

    /**
     * Setter for property 'areaToolOptionsPenDashStyle'.
     * @param areaToolOptionsPenDashStyle Value to set for property 'areaToolOptionsPenDashStyle'.
     */
    @SuppressWarnings("unused")
    public void setAreaToolOptionsPenDashStyle(Integer areaToolOptionsPenDashStyle) {
        this.areaToolOptionsPenDashStyle = areaToolOptionsPenDashStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAreaToolOptionsBrushColor() {
        return areaToolOptionsBrushColor;
    }

    /**
     * Setter for property 'areaToolOptionsBrushColor'.
     * @param areaToolOptionsBrushColor Value to set for property 'areaToolOptionsBrushColor'.
     */
    @SuppressWarnings("unused")
    public void setAreaToolOptionsBrushColor(String areaToolOptionsBrushColor) {
        this.areaToolOptionsBrushColor = areaToolOptionsBrushColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPolylineToolOptionsPenWidth() {
        return polylineToolOptionsPenWidth;
    }

    /**
     * Setter for property 'polylineToolOptionsPenWidth'.
     * @param polylineToolOptionsPenWidth Value to set for property 'polylineToolOptionsPenWidth'.
     */
    @SuppressWarnings("unused")
    public void setPolylineToolOptionsPenWidth(Integer polylineToolOptionsPenWidth) {
        this.polylineToolOptionsPenWidth = polylineToolOptionsPenWidth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPolylineToolOptionsPenColor() {
        return polylineToolOptionsPenColor;
    }

    /**
     * Setter for property 'polylineToolOptionsPenColor'.
     * @param polylineToolOptionsPenColor Value to set for property 'polylineToolOptionsPenColor'.
     */
    @SuppressWarnings("unused")
    public void setPolylineToolOptionsPenColor(String polylineToolOptionsPenColor) {
        this.polylineToolOptionsPenColor = polylineToolOptionsPenColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPolylineToolOptionsPenDashStyle() {
        return polylineToolOptionsPenDashStyle;
    }

    /**
     * Setter for property 'polylineToolOptionsPenDashStyle'.
     * @param polylineToolOptionsPenDashStyle Value to set for property 'polylineToolOptionsPenDashStyle'.
     */
    @SuppressWarnings("unused")
    public void setPolylineToolOptionsPenDashStyle(Integer polylineToolOptionsPenDashStyle) {
        this.polylineToolOptionsPenDashStyle = polylineToolOptionsPenDashStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPolylineToolOptionsBrushColor() {
        return polylineToolOptionsBrushColor;
    }

    /**
     * Setter for property 'polylineToolOptionsBrushColor'.
     * @param polylineToolOptionsBrushColor Value to set for property 'polylineToolOptionsBrushColor'.
     */
    @SuppressWarnings("unused")
    public void setPolylineToolOptionsBrushColor(String polylineToolOptionsBrushColor) {
        this.polylineToolOptionsBrushColor = polylineToolOptionsBrushColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getArrowToolOptionsPenWidth() {
        return arrowToolOptionsPenWidth;
    }

    /**
     * Setter for property 'arrowToolOptionsPenWidth'.
     * @param arrowToolOptionsPenWidth Value to set for property 'arrowToolOptionsPenWidth'.
     */
    @SuppressWarnings("unused")
    public void setArrowToolOptionsPenWidth(Integer arrowToolOptionsPenWidth) {
        this.arrowToolOptionsPenWidth = arrowToolOptionsPenWidth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getArrowToolOptionsPenColor() {
        return arrowToolOptionsPenColor;
    }

    /**
     * Setter for property 'arrowToolOptionsPenColor'.
     * @param arrowToolOptionsPenColor Value to set for property 'arrowToolOptionsPenColor'.
     */
    @SuppressWarnings("unused")
    public void setArrowToolOptionsPenColor(String arrowToolOptionsPenColor) {
        this.arrowToolOptionsPenColor = arrowToolOptionsPenColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getArrowToolOptionsPenDashStyle() {
        return arrowToolOptionsPenDashStyle;
    }

    /**
     * Setter for property 'arrowToolOptionsPenDashStyle'.
     * @param arrowToolOptionsPenDashStyle Value to set for property 'arrowToolOptionsPenDashStyle'.
     */
    @SuppressWarnings("unused")
    public void setArrowToolOptionsPenDashStyle(Integer arrowToolOptionsPenDashStyle) {
        this.arrowToolOptionsPenDashStyle = arrowToolOptionsPenDashStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getArrowToolOptionsBrushColor() {
        return arrowToolOptionsBrushColor;
    }

    /**
     * Setter for property 'arrowToolOptionsBrushColor'.
     * @param arrowToolOptionsBrushColor Value to set for property 'arrowToolOptionsBrushColor'.
     */
    @SuppressWarnings("unused")
    public void setArrowToolOptionsBrushColor(String arrowToolOptionsBrushColor) {
        this.arrowToolOptionsBrushColor = arrowToolOptionsBrushColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPenColor() {
        return penColor;
    }

    /**
     * Setter for property 'penColor'.
     * @param penColor Value to set for property 'penColor'.
     */
    @SuppressWarnings("unused")
    public void setPenColor(String penColor) {
        this.penColor = penColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPenWidth() {
        return penWidth;
    }

    /**
     * Setter for property 'penWidth'.
     * @param penWidth Value to set for property 'penWidth'.
     */
    @SuppressWarnings("unused")
    public void setPenWidth(Integer penWidth) {
        this.penWidth = penWidth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPenStyle() {
        return penStyle;
    }

    /**
     * Setter for property 'penStyle'.
     * @param penStyle Value to set for property 'penStyle'.
     */
    @SuppressWarnings("unused")
    public void setPenStyle(Integer penStyle) {
        this.penStyle = penStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getEnabledTools() {
        return enabledTools;
    }

    /**
     * Setter for property 'enabledTools'.
     * @param enabledTools Value to set for property 'enabledTools'.
     */
    @SuppressWarnings("unused")
    public void setEnabledTools(Integer enabledTools) {
        this.enabledTools = enabledTools;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getConnectorPosition() {
        return connectorPosition;
    }

    /**
     * Setter for property 'connectorPosition'.
     * @param connectorPosition Value to set for property 'connectorPosition'.
     */
    @SuppressWarnings("unused")
    public void setConnectorPosition(Integer connectorPosition) {
        this.connectorPosition = connectorPosition;
    }

    /**
     * Getter for property 'saveReplyOnFocusLoss'.
     * @return Value for property 'saveReplyOnFocusLoss'.
     */
    public Boolean isSaveReplyOnFocusLoss() {
        return saveReplyOnFocusLoss;
    }

    /**
     * Setter for property 'saveReplyOnFocusLoss'.
     * @param saveReplyOnFocusLoss Value to set for property 'saveReplyOnFocusLoss'.
     */
    @SuppressWarnings("unused")
    public void setSaveReplyOnFocusLoss(Boolean saveReplyOnFocusLoss) {
        this.saveReplyOnFocusLoss = saveReplyOnFocusLoss;
    }

    /**
     * Getter for property 'clickableAnnotations'.
     * @return Value for property 'clickableAnnotations'.
     */
    public Boolean isClickableAnnotations() {
        return clickableAnnotations;
    }

    /**
     * Setter for property 'clickableAnnotations'.
     * @param clickableAnnotations Value to set for property 'clickableAnnotations'.
     */
    @SuppressWarnings("unused")
    public void setClickableAnnotations(Boolean clickableAnnotations) {
        this.clickableAnnotations = clickableAnnotations;
    }

    /**
     * Getter for property 'disconnectUncommented'.
     * @return Value for property 'disconnectUncommented'.
     */
    public Boolean isDisconnectUncommented() {
        return disconnectUncommented;
    }

    /**
     * Setter for property 'disconnectUncommented'.
     * @param disconnectUncommented Value to set for property 'disconnectUncommented'.
     */
    @SuppressWarnings("unused")
    public void setDisconnectUncommented(Boolean disconnectUncommented) {
        this.disconnectUncommented = disconnectUncommented;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getStrikeoutMode() {
        return strikeoutMode;
    }

    /**
     * Setter for property 'strikeoutMode'.
     * @param strikeoutMode Value to set for property 'strikeoutMode'.
     */
    @SuppressWarnings("unused")
    public void setStrikeoutMode(Integer strikeoutMode) {
        this.strikeoutMode = strikeoutMode;
    }

    /**
     * Getter for property 'anyToolSelection'.
     * @return Value for property 'anyToolSelection'.
     */
    public Boolean isAnyToolSelection() {
        return anyToolSelection;
    }

    /**
     * Setter for property 'anyToolSelection'.
     * @param anyToolSelection Value to set for property 'anyToolSelection'.
     */
    @SuppressWarnings("unused")
    public void setAnyToolSelection(Boolean anyToolSelection) {
        this.anyToolSelection = anyToolSelection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSidebarContainerSelector() {
        return sidebarContainerSelector;
    }

    /**
     * Setter for property 'sidebarContainerSelector'.
     * @param sidebarContainerSelector Value to set for property 'sidebarContainerSelector'.
     */
    @SuppressWarnings("unused")
    public void setSidebarContainerSelector(String sidebarContainerSelector) {
        this.sidebarContainerSelector = sidebarContainerSelector;
    }

    /**
     * Getter for property 'usePageNumberInUrlHash'.
     * @return Value for property 'usePageNumberInUrlHash'.
     */
    public Boolean isUsePageNumberInUrlHash() {
        return usePageNumberInUrlHash;
    }

    /**
     * Setter for property 'usePageNumberInUrlHash'.
     * @param usePageNumberInUrlHash Value to set for property 'usePageNumberInUrlHash'.
     */
    @SuppressWarnings("unused")
    public void setUsePageNumberInUrlHash(Boolean usePageNumberInUrlHash) {
        this.usePageNumberInUrlHash = usePageNumberInUrlHash;
    }

    /**
     * Getter for property 'textSelectionSynchronousCalculation'.
     * @return Value for property 'textSelectionSynchronousCalculation'.
     */
    public Boolean isTextSelectionSynchronousCalculation() {
        return textSelectionSynchronousCalculation;
    }

    /**
     * Setter for property 'textSelectionSynchronousCalculation'.
     * @param textSelectionSynchronousCalculation Value to set for property 'textSelectionSynchronousCalculation'.
     */
    @SuppressWarnings("unused")
    public void setTextSelectionSynchronousCalculation(Boolean textSelectionSynchronousCalculation) {
        this.textSelectionSynchronousCalculation = textSelectionSynchronousCalculation;
    }

    /**
     * Getter for property 'variableHeightPageSupport'.
     * @return Value for property 'variableHeightPageSupport'.
     */
    public Boolean isVariableHeightPageSupport() {
        return variableHeightPageSupport;
    }

    /**
     * Setter for property 'variableHeightPageSupport'.
     * @param variableHeightPageSupport Value to set for property 'variableHeightPageSupport'.
     */
    @SuppressWarnings("unused")
    public void setVariableHeightPageSupport(Boolean variableHeightPageSupport) {
        this.variableHeightPageSupport = variableHeightPageSupport;
    }

    /**
     * Getter for property 'createMarkup'.
     * @return Value for property 'createMarkup'.
     */
    public Boolean isCreateMarkup() {
        return createMarkup;
    }

    /**
     * Setter for property 'createMarkup'.
     * @param createMarkup Value to set for property 'createMarkup'.
     */
    @SuppressWarnings("unused")
    public void setCreateMarkup(Boolean createMarkup) {
        this.createMarkup = createMarkup;
    }

    /**
     * Getter for property 'use_pdf'.
     * @return Value for property 'use_pdf'.
     */
    public Boolean isUse_pdf() {
        return use_pdf;
    }

    /**
     * Setter for property 'use_pdf'.
     * @param use_pdf Value to set for property 'use_pdf'.
     */
    @SuppressWarnings("unused")
    public void setUse_pdf(Boolean use_pdf) {
        this.use_pdf = use_pdf;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMode() {
        return mode;
    }

    /**
     * Setter for property 'mode'.
     * @param mode Value to set for property 'mode'.
     */
    @SuppressWarnings("unused")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSelectionContainerSelector() {
        return selectionContainerSelector;
    }

    /**
     * Setter for property 'selectionContainerSelector'.
     * @param selectionContainerSelector Value to set for property 'selectionContainerSelector'.
     */
    @SuppressWarnings("unused")
    public void setSelectionContainerSelector(String selectionContainerSelector) {
        this.selectionContainerSelector = selectionContainerSelector;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getGraphicsContainerSelector() {
        return graphicsContainerSelector;
    }

    /**
     * Setter for property 'graphicsContainerSelector'.
     * @param graphicsContainerSelector Value to set for property 'graphicsContainerSelector'.
     */
    @SuppressWarnings("unused")
    public void setGraphicsContainerSelector(String graphicsContainerSelector) {
        this.graphicsContainerSelector = graphicsContainerSelector;
    }

    /**
     * Getter for property 'useBrowserCache'.
     * @return Value for property 'useBrowserCache'.
     */
    public Boolean isUseBrowserCache() {
        return useBrowserCache;
    }

    /**
     * Setter for property 'useBrowserCache'.
     * @param useBrowserCache Value to set for property 'useBrowserCache'.
     */
    @SuppressWarnings("unused")
    public void setUseBrowserCache(Boolean useBrowserCache) {
        this.useBrowserCache = useBrowserCache;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWidgetId() {
        return widgetId;
    }

    /**
     * Setter for property 'widgetId'.
     * @param widgetId Value to set for property 'widgetId'.
     */
    @SuppressWarnings("unused")
    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    /**
     * Getter for property 'rightPanelEnabled'.
     * @return Value for property 'rightPanelEnabled'.
     */
    public Boolean isRightPanelEnabled() {
        return rightPanelEnabled;
    }

    /**
     * Setter for property 'rightPanelEnabled'.
     * @param rightPanelEnabled Value to set for property 'rightPanelEnabled'.
     */
    @SuppressWarnings("unused")
    public void setRightPanelEnabled(Boolean rightPanelEnabled) {
        this.rightPanelEnabled = rightPanelEnabled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getMaxCacheSize() {
        return maxCacheSize;
    }

    /**
     * Setter for property 'maxCacheSize'.
     * @param maxCacheSize Value to set for property 'maxCacheSize'.
     */
    @SuppressWarnings("unused")
    public void setMaxCacheSize(Long maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUploadPath() {
        return uploadPath;
    }

    /**
     * Setter for property 'uploadPath'.
     * @param uploadPath Value to set for property 'uploadPath'.
     */
    @SuppressWarnings("unused")
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    /**
     * Getter for property 'undoEnabled'.
     * @return Value for property 'undoEnabled'.
     */
    public Boolean isUndoEnabled() {
        return undoEnabled;
    }

    /**
     * Setter for property 'undoEnabled'.
     * @param undoEnabled Value to set for property 'undoEnabled'.
     */
    @SuppressWarnings("unused")
    public void setUndoEnabled(Boolean undoEnabled) {
        this.undoEnabled = undoEnabled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getJqueryFileDownloadCookieName() {
        return jqueryFileDownloadCookieName;
    }

    /**
     * Setter for property 'jqueryFileDownloadCookieName'.
     * @param jqueryFileDownloadCookieName Value to set for property 'jqueryFileDownloadCookieName'.
     */
    @SuppressWarnings("unused")
    public void setJqueryFileDownloadCookieName(String jqueryFileDownloadCookieName) {
        this.jqueryFileDownloadCookieName = jqueryFileDownloadCookieName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getWatermarkFontSize() {
        return watermarkFontSize;
    }

    /**
     * Setter for property 'watermarkFontSize'.
     * @param watermarkFontSize Value to set for property 'watermarkFontSize'.
     */
    @SuppressWarnings("unused")
    public void setWatermarkFontSize(Integer watermarkFontSize) {
        this.watermarkFontSize = watermarkFontSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWatermarkPosition() {
        return watermarkPosition;
    }

    /**
     * Setter for property 'watermarkPosition'.
     * @param watermarkPosition Value to set for property 'watermarkPosition'.
     */
    @SuppressWarnings("unused")
    public void setWatermarkPosition(String watermarkPosition) {
        this.watermarkPosition = watermarkPosition;
    }

    @Override
    public String getWatermarkText() {
        return watermarkText;
    }

    /**
     * Sets watermark text.
     * @param watermarkText the watermark text
     */
    public void setWatermarkText(String watermarkText) {
        this.watermarkText = watermarkText;
    }

    /**
     * Getter for property 'convertWordDocumentsCompletely'.
     * @return Value for property 'convertWordDocumentsCompletely'.
     */
    public Boolean isConvertWordDocumentsCompletely() {
        return convertWordDocumentsCompletely;
    }

    /**
     * Gets file display name
     * @return file display name
     */
    @Override
    public String getFileDisplayName() {
        return fileDisplayName;
    }

    /**
     * Sets file display name.
     * @param fileDisplayName the file display name
     */
    @SuppressWarnings("unused")
    public void setFileDisplayName(String fileDisplayName) {
        this.fileDisplayName = fileDisplayName;
    }

    /**
     * Setter for property 'convertWordDocumentsCompletely'.
     * @param convertWordDocumentsCompletely Value to set for property 'convertWordDocumentsCompletely'.
     */
    @SuppressWarnings("unused")
    public void setConvertWordDocumentsCompletely(Boolean convertWordDocumentsCompletely) {
        this.convertWordDocumentsCompletely = convertWordDocumentsCompletely;
    }

    /**
     * Getter for property 'ignoreDocumentAbsence'.
     * @return Value for property 'ignoreDocumentAbsence'.
     */
    public Boolean isIgnoreDocumentAbsence() {
        return ignoreDocumentAbsence;
    }

    /**
     * Setter for property 'ignoreDocumentAbsence'.
     * @param ignoreDocumentAbsence Value to set for property 'ignoreDocumentAbsence'.
     */
    @SuppressWarnings("unused")
    public void setIgnoreDocumentAbsence(Boolean ignoreDocumentAbsence) {
        this.ignoreDocumentAbsence = ignoreDocumentAbsence;
    }

    /**
     * Getter for property 'preloadPagesOnBrowserSide'.
     * @return Value for property 'preloadPagesOnBrowserSide'.
     */
    public Boolean isPreloadPagesOnBrowserSide() {
        return preloadPagesOnBrowserSide;
    }

    /**
     * Setter for property 'preloadPagesOnBrowserSide'.
     * @param preloadPagesOnBrowserSide Value to set for property 'preloadPagesOnBrowserSide'.
     */
    @SuppressWarnings("unused")
    public void setPreloadPagesOnBrowserSide(Boolean preloadPagesOnBrowserSide) {
        this.preloadPagesOnBrowserSide = preloadPagesOnBrowserSide;
    }

    /**
     * Getter for property 'printWithWatermark'.
     * @return Value for property 'printWithWatermark'.
     */
    public Boolean isPrintWithWatermark() {
        return printWithWatermark;
    }

    /**
     * Setter for property 'printWithWatermark'.
     * @param printWithWatermark Value to set for property 'printWithWatermark'.
     */
    @SuppressWarnings("unused")
    public void setPrintWithWatermark(Boolean printWithWatermark) {
        this.printWithWatermark = printWithWatermark;
    }

    /**
     * Getter for property 'supportPageRotation'.
     * @return Value for property 'supportPageRotation'.
     */
    public Boolean isSupportPageRotation() {
        return supportPageRotation;
    }

    /**
     * Setter for property 'supportPageRotation'.
     * @param supportPageRotation Value to set for property 'supportPageRotation'.
     */
    @SuppressWarnings("unused")
    public void setSupportPageRotation(Boolean supportPageRotation) {
        this.supportPageRotation = supportPageRotation;
    }

    /**
     * Getter for property 'storeLogic'.
     * @return Value for property 'storeLogic'.
     */
    public String getStoreLogic() {
        return storeLogic;
    }

    /**
     * Setter for property 'storeLogic'.
     * @param storeLogic Value to set for property 'storeLogic'.
     */
    @SuppressWarnings("unused")
    public void setStoreLogic(String storeLogic) {
        this.storeLogic = storeLogic;
    }

    /**
     * Getter for property 'printAnnotations'.
     * @return Value for property 'printAnnotations'.
     */
    public Boolean isPrintAnnotations() {
        return printAnnotations;
    }

    /**
     * Setter for property 'printAnnotations'.
     * @param printAnnotations Value to set for property 'printAnnotations'.
     */
    @SuppressWarnings("unused")
    public void setPrintAnnotations(Boolean printAnnotations) {
        this.printAnnotations = printAnnotations;
    }

    /**
     * Gets disable atmosphere.
     * @return the disable atmosphere
     */
    @Override
    public Boolean isDisableAtmosphere() {
        return disableAtmosphere;
    }

    @Override
    public Boolean isCaseSensitive() {
        return isCaseSensitive;
    }

    /**
     * Sets is case sensitive.
     * @param isCaseSensitive the is case sensitive
     */
    @SuppressWarnings("unused")
    public void setIsCaseSensitive(Boolean isCaseSensitive) {
        this.isCaseSensitive = isCaseSensitive;
    }

    @Override
    public Boolean isSearchForSeparateWords() {
        return searchForSeparateWords;
    }

    /**
     * Sets search for separate words.
     * @param searchForSeparateWords the search for separate words
     */
    @SuppressWarnings("unused")
    public void setSearchForSeparateWords(Boolean searchForSeparateWords) {
        this.searchForSeparateWords = searchForSeparateWords;
    }

    /**
     * Sets disable atmosphere.
     * @param disableAtmosphere the disable atmosphere
     */
    @SuppressWarnings("unused")
    public void setDisableAtmosphere(Boolean disableAtmosphere) {
        this.disableAtmosphere = disableAtmosphere;
    }

    /**
     * Getter for property 'localization'.
     * @return Value for property 'localization'.
     */
    public String getLocalization() {
        return localization;
    }

    /**
     * Setter for property 'localization'.
     * @param localization Value to set for property 'localization'.
     */
    @SuppressWarnings("unused")
    public void setLocalization(String localization) {
        this.localization = localization;
    }

    /**
     * Gets default file name.
     * @return the default file name
     */
    public String getDefaultFileName() {
        return defaultFileName;
    }

    /**
     * Sets default file name.
     * @param defaultFileName the default file name
     */
    public void setDefaultFileName(String defaultFileName) {
        this.defaultFileName = defaultFileName;
    }
}
