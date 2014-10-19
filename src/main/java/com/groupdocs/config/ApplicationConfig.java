package com.groupdocs.config;

import com.groupdocs.annotation.config.ServiceConfigurationBase;
import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * @author Aleksey Permyakov
 */
@Component
public class ApplicationConfig extends ServiceConfigurationBase {
    @Property(key = "groupdocs.annotation.licensePath")
    protected String licensePath;
    @Property(key = "groupdocs.annotation.applicationPath")
    protected String applicationPath;
    @Property(key = "groupdocs.annotation.basePath")
    protected String basePath;
    @Property(key = "groupdocs.annotation.storageType")
    protected String storageType;
    @Property(key = "groupdocs.annotation.dbServer")
    protected String dbServer;
    @Property(key = "groupdocs.annotation.dbPort")
    protected Integer dbPort;
    @Property(key = "groupdocs.annotation.dbName")
    protected String dbName;
    @Property(key = "groupdocs.annotation.dbUsername")
    protected String dbUsername;
    @Property(key = "groupdocs.annotation.dbPassword")
    protected String dbPassword;
    @Property(key = "groupdocs.annotation.storagePath")
    protected String storagePath;
    @Property(key = "groupdocs.annotation.useAuthorization")
    protected Boolean useAuthorization;
    @Property(key = "groupdocs.annotation.useCache")
    protected Boolean useCache;
    @Property(key = "groupdocs.annotation.expirationDate")
    protected Integer expirationDate;
    @Property(key = "groupdocs.annotation.encryptionKey")
    protected String encryptionKey;
    @Property(key = "groupdocs.annotation.localesPath")
    protected String localesPath;
    @Property(key = "groupdocs.annotation.quality")
    protected Integer quality;
    @Property(key = "groupdocs.annotation.showThumbnails")
    protected Boolean showThumbnails;
    @Property(key = "groupdocs.annotation.openThumbnails")
    protected Boolean openThumbnails;
    @Property(key = "groupdocs.annotation.initialZoom")
    protected Integer initialZoom;
    @Property(key = "groupdocs.annotation.zoomToFitWidth")
    protected Boolean zoomToFitWidth;
    @Property(key = "groupdocs.annotation.zoomToFitHeight")
    protected Boolean zoomToFitHeight;
    @Property(key = "groupdocs.annotation.width")
    protected Integer width;
    @Property(key = "groupdocs.annotation.height")
    protected Integer height;
    @Property(key = "groupdocs.annotation.showPrint")
    protected Boolean showPrInteger;
    @Property(key = "groupdocs.annotation.showZoom")
    protected Boolean showZoom;
    @Property(key = "groupdocs.annotation.showPaging")
    protected Boolean showPaging;
    @Property(key = "groupdocs.annotation.preloadPagesCount")
    protected Integer preloadPagesCount;
    @Property(key = "groupdocs.annotation.showHeader")
    protected Boolean showHeader;
    @Property(key = "groupdocs.annotation.showFileExplorer")
    protected Boolean showFileExplorer;
    @Property(key = "groupdocs.annotation.useEmScaling")
    protected Boolean useEmScaling;
    @Property(key = "groupdocs.annotation.enableRightClickMenu")
    protected Boolean enableRightClickMenu;
    @Property(key = "groupdocs.annotation.showToolbar")
    protected Boolean showToolbar;
    @Property(key = "groupdocs.annotation.enableSidePanel")
    protected Boolean enableSidePanel;
    @Property(key = "groupdocs.annotation.scrollOnFocus")
    protected Boolean scrollOnFocus;
    @Property(key = "groupdocs.annotation.enabledTools")
    protected Integer enabledTools;
    @Property(key = "groupdocs.annotation.connectorPosition")
    protected Integer connectorPosition;
    @Property(key = "groupdocs.annotation.saveReplyOnFocusLoss")
    protected Boolean saveReplyOnFocusLoss;
    @Property(key = "groupdocs.annotation.clickableAnnotations")
    protected Boolean clickableAnnotations;
    @Property(key = "groupdocs.annotation.disconnectUncommented")
    protected Boolean disconnectUncommented;
    @Property(key = "groupdocs.annotation.strikeoutMode")
    protected Integer strikeoutMode;
    @Property(key = "groupdocs.annotation.anyToolSelection")
    protected Boolean anyToolSelection;
    @Property(key = "groupdocs.annotation.sidebarContainerSelector")
    protected String sidebarContainerSelector;
    @Property(key = "groupdocs.annotation.usePageNumberInUrlHash")
    protected Boolean usePageNumberInUrlHash;
    @Property(key = "groupdocs.annotation.textSelectionSynchronousCalculation")
    protected Boolean textSelectionSynchronousCalculation;
    @Property(key = "groupdocs.annotation.variableHeightPageSupport")
    protected Boolean variableHeightPageSupport;
    @Property(key = "groupdocs.annotation.createMarkup")
    protected Boolean createMarkup;
    @Property(key = "groupdocs.annotation.use_pdf")
    protected Boolean use_pdf;
    @Property(key = "groupdocs.annotation.mode")
    protected String mode;
    @Property(key = "groupdocs.annotation.selectionContainerSelector")
    protected String selectionContainerSelector;
    @Property(key = "groupdocs.annotation.graphicsContainerSelector")
    protected String graphicsContainerSelector;
    @Property(key = "groupdocs.annotation.useBrowserCache")
    protected Boolean useBrowserCache;
    @Property(key = "groupdocs.annotation.widgetId")
    protected String widgetId;
    @Property(key = "groupdocs.annotation.rightPanelEnabled")
    protected boolean rightPanelEnabled;
    @Property(key = "groupdocs.annotation.maxCacheSize")
    protected Long maxCacheSize;
    @Property(key = "groupdocs.annotation.uploadPath")
    private String uploadPath;
    @Property(key = "groupdocs.annotation.undoEnabled")
    private Boolean undoEnabled;
    @Property(key = "groupdocs.annotation.fileDisplayName")
    private String fileDisplayName;
    @Property(key = "groupdocs.annotation.jqueryFileDownloadCookieName")
    private String jqueryFileDownloadCookieName;
    @Property(key = "groupdocs.annotation.watermarkFontSize")
    private Integer watermarkFontSize;
    @Property(key = "groupdocs.annotation.watermarkPosition")
    private String watermarkPosition;
    @Property(key = "groupdocs.annotation.convertWordDocumentsCompletely")
    private Boolean convertWordDocumentsCompletely;
    @Property(key = "groupdocs.annotation.ignoreDocumentAbsence")
    private Boolean ignoreDocumentAbsence;
    @Property(key = "groupdocs.annotation.preloadPagesOnBrowserSide")
    private Boolean preloadPagesOnBrowserSide;
    @Property(key = "groupdocs.annotation.printWithWatermark")
    private Boolean printWithWatermark;
    @Property(key = "groupdocs.annotation.supportPageRotation")
    private Boolean supportPageRotation;
    @Property(key = "groupdocs.annotation.storeLogic")
    private String storeLogic;
    @Property(key = "groupdocs.annotation.printAnnotations")
    private Boolean printAnnotations;

    @Override
    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    @Override
    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    @Override
    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getDbServer() {
        return dbServer;
    }

    public void setDbServer(String dbServer) {
        this.dbServer = dbServer;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getStoragePath() {
        return storagePath == null || "null".equals(storagePath) ? null : storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    @Override
    public Boolean isUseAuthorization() {
        return useAuthorization;
    }

    @Override
    public Boolean isUseCache() {
        return useCache;
    }

    @Override
    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    @Override
    public String getLocalesPath() {
        return localesPath;
    }

    public void setLocalesPath(String localesPath) {
        this.localesPath = localesPath;
    }

    @Override
    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Override
    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    @Override
    public Boolean isShowThumbnails() {
        return showThumbnails;
    }

    @Override
    public Boolean isOpenThumbnails() {
        return openThumbnails;
    }

    @Override
    public Integer getInitialZoom() {
        return initialZoom;
    }

    public void setInitialZoom(Integer initialZoom) {
        this.initialZoom = initialZoom;
    }

    @Override
    public String getJqueryFileDownloadCookieName() {
        return jqueryFileDownloadCookieName;
    }

    public void setJqueryFileDownloadCookieName(String jqueryFileDownloadCookieName) {
        this.jqueryFileDownloadCookieName = jqueryFileDownloadCookieName;
    }

    @Override
    public Boolean isZoomToFitWidth() {
        return zoomToFitWidth;
    }

    @Override
    public Boolean isZoomToFitHeight() {
        return zoomToFitHeight;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Boolean isConvertWordDocumentsCompletely() {
        return convertWordDocumentsCompletely;
    }

    @Override
    public String getFileDisplayName() {
        return fileDisplayName;
    }

    public void setFileDisplayName(String fileDisplayName) {
        this.fileDisplayName = fileDisplayName;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public Boolean isIgnoreDocumentAbsence() {
        return ignoreDocumentAbsence;
    }

    @Override
    public Boolean isShowPrint() {
        return showPrInteger;
    }

    @Override
    public Boolean isShowZoom() {
        return showZoom;
    }

    @Override
    public Boolean isSupportPageRotation() {
        return supportPageRotation;
    }

    @Override
    public Boolean isShowPaging() {
        return showPaging;
    }

    @Override
    public Integer getPreloadPagesCount() {
        return preloadPagesCount;
    }

    public void setPreloadPagesCount(Integer preloadPagesCount) {
        this.preloadPagesCount = preloadPagesCount;
    }

    @Override
    public Boolean isPreloadPagesOnBrowserSide() {
        return preloadPagesOnBrowserSide;
    }

    @Override
    public Boolean isPrintWithWatermark() {
        return null;
    }

    @Override
    public Boolean isShowHeader() {
        return showHeader;
    }

    @Override
    public Boolean isShowFileExplorer() {
        return showFileExplorer;
    }

    @Override
    public Boolean isUndoEnabled() {
        return undoEnabled;
    }

    @Override
    public Boolean isUseEmScaling() {
        return useEmScaling;
    }

    @Override
    public Integer getWatermarkFontSize() {
        return watermarkFontSize;
    }

    public void setWatermarkFontSize(Integer watermarkFontSize) {
        this.watermarkFontSize = watermarkFontSize;
    }

    @Override
    public String getWatermarkPosition() {
        return watermarkPosition;
    }

    public void setWatermarkPosition(String watermarkPosition) {
        this.watermarkPosition = watermarkPosition;
    }

    @Override
    public Long getMaxCacheSize() {
        return maxCacheSize;
    }

    public void setMaxCacheSize(Long maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    public void setMaxCacheSize(long maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public Boolean isEnableRightClickMenu() {
        return enableRightClickMenu;
    }

    @Override
    public Boolean isShowToolbar() {
        return showToolbar;
    }

    @Override
    public Boolean isEnableSidePanel() {
        return enableSidePanel;
    }

    @Override
    public Boolean isScrollOnFocus() {
        return scrollOnFocus;
    }

    @Override
    public Integer getEnabledTools() {
        return enabledTools;
    }

    public void setEnabledTools(Integer enabledTools) {
        this.enabledTools = enabledTools;
    }

    @Override
    public Integer getConnectorPosition() {
        return connectorPosition;
    }

    public void setConnectorPosition(Integer connectorPosition) {
        this.connectorPosition = connectorPosition;
    }

    @Override
    public Boolean isSaveReplyOnFocusLoss() {
        return saveReplyOnFocusLoss;
    }

    @Override
    public Boolean isClickableAnnotations() {
        return clickableAnnotations;
    }

    @Override
    public Boolean isDisconnectUncommented() {
        return disconnectUncommented;
    }

    @Override
    public Integer getStrikeoutMode() {
        return strikeoutMode;
    }

    public void setStrikeoutMode(Integer strikeoutMode) {
        this.strikeoutMode = strikeoutMode;
    }

    @Override
    public Boolean isAnyToolSelection() {
        return anyToolSelection;
    }

    @Override
    public Boolean isPrintAnnotations() {
        return printAnnotations;
    }

    public void setPrintAnnotations(Boolean printAnnotations) {
        this.printAnnotations = printAnnotations;
    }

    @Override
    public String getSidebarContainerSelector() {
        return sidebarContainerSelector;
    }

    public void setSidebarContainerSelector(String sidebarContainerSelector) {
        this.sidebarContainerSelector = sidebarContainerSelector;
    }

    @Override
    public Boolean isUsePageNumberInUrlHash() {
        return usePageNumberInUrlHash;
    }

    @Override
    public Boolean isTextSelectionSynchronousCalculation() {
        return textSelectionSynchronousCalculation;
    }

    @Override
    public Boolean isVariableHeightPageSupport() {
        return variableHeightPageSupport;
    }

    @Override
    public Boolean isCreateMarkup() {
        return createMarkup;
    }

    @Override
    public Boolean isUse_pdf() {
        return use_pdf;
    }

    @Override
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String getSelectionContainerSelector() {
        return selectionContainerSelector;
    }

    public void setSelectionContainerSelector(String selectionContainerSelector) {
        this.selectionContainerSelector = selectionContainerSelector;
    }

    @Override
    public String getGraphicsContainerSelector() {
        return graphicsContainerSelector;
    }

    public void setGraphicsContainerSelector(String graphicsContainerSelector) {
        this.graphicsContainerSelector = graphicsContainerSelector;
    }

    @Override
    public Boolean isUseBrowserCache() {
        return useBrowserCache;
    }

    @Override
    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    public Boolean getUseAuthorization() {
        return useAuthorization;
    }

    public void setUseAuthorization(Boolean useAuthorization) {
        this.useAuthorization = useAuthorization;
    }

    public Boolean getUseCache() {
        return useCache;
    }

    public void setUseCache(Boolean useCache) {
        this.useCache = useCache;
    }

    public Boolean getShowThumbnails() {
        return showThumbnails;
    }

    public void setShowThumbnails(Boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    public Boolean getOpenThumbnails() {
        return openThumbnails;
    }

    public void setOpenThumbnails(Boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    public Boolean getZoomToFitWidth() {
        return zoomToFitWidth;
    }

    public void setZoomToFitWidth(Boolean zoomToFitWidth) {
        this.zoomToFitWidth = zoomToFitWidth;
    }

    public Boolean getZoomToFitHeight() {
        return zoomToFitHeight;
    }

    public void setZoomToFitHeight(Boolean zoomToFitHeight) {
        this.zoomToFitHeight = zoomToFitHeight;
    }

    public Boolean getShowPrInteger() {
        return showPrInteger;
    }

    public void setShowPrInteger(Boolean showPrInteger) {
        this.showPrInteger = showPrInteger;
    }

    public Boolean getShowZoom() {
        return showZoom;
    }

    public void setShowZoom(Boolean showZoom) {
        this.showZoom = showZoom;
    }

    public Boolean getShowPaging() {
        return showPaging;
    }

    public void setShowPaging(Boolean showPaging) {
        this.showPaging = showPaging;
    }

    public Boolean getShowHeader() {
        return showHeader;
    }

    public void setShowHeader(Boolean showHeader) {
        this.showHeader = showHeader;
    }

    public Boolean getShowFileExplorer() {
        return showFileExplorer;
    }

    public void setShowFileExplorer(Boolean showFileExplorer) {
        this.showFileExplorer = showFileExplorer;
    }

    public Boolean getUseEmScaling() {
        return useEmScaling;
    }

    public void setUseEmScaling(Boolean useEmScaling) {
        this.useEmScaling = useEmScaling;
    }

    public Boolean getEnableRightClickMenu() {
        return enableRightClickMenu;
    }

    public void setEnableRightClickMenu(Boolean enableRightClickMenu) {
        this.enableRightClickMenu = enableRightClickMenu;
    }

    public Boolean getShowToolbar() {
        return showToolbar;
    }

    public void setShowToolbar(Boolean showToolbar) {
        this.showToolbar = showToolbar;
    }

    public Boolean getEnableSidePanel() {
        return enableSidePanel;
    }

    public void setEnableSidePanel(Boolean enableSidePanel) {
        this.enableSidePanel = enableSidePanel;
    }

    public Boolean getScrollOnFocus() {
        return scrollOnFocus;
    }

    public void setScrollOnFocus(Boolean scrollOnFocus) {
        this.scrollOnFocus = scrollOnFocus;
    }

    public Boolean getSaveReplyOnFocusLoss() {
        return saveReplyOnFocusLoss;
    }

    public void setSaveReplyOnFocusLoss(Boolean saveReplyOnFocusLoss) {
        this.saveReplyOnFocusLoss = saveReplyOnFocusLoss;
    }

    public Boolean getClickableAnnotations() {
        return clickableAnnotations;
    }

    public void setClickableAnnotations(Boolean clickableAnnotations) {
        this.clickableAnnotations = clickableAnnotations;
    }

    public Boolean getDisconnectUncommented() {
        return disconnectUncommented;
    }

    public void setDisconnectUncommented(Boolean disconnectUncommented) {
        this.disconnectUncommented = disconnectUncommented;
    }

    public Boolean getAnyToolSelection() {
        return anyToolSelection;
    }

    public void setAnyToolSelection(Boolean anyToolSelection) {
        this.anyToolSelection = anyToolSelection;
    }

    public Boolean getUsePageNumberInUrlHash() {
        return usePageNumberInUrlHash;
    }

    public void setUsePageNumberInUrlHash(Boolean usePageNumberInUrlHash) {
        this.usePageNumberInUrlHash = usePageNumberInUrlHash;
    }

    public Boolean getTextSelectionSynchronousCalculation() {
        return textSelectionSynchronousCalculation;
    }

    public void setTextSelectionSynchronousCalculation(Boolean textSelectionSynchronousCalculation) {
        this.textSelectionSynchronousCalculation = textSelectionSynchronousCalculation;
    }

    public Boolean getVariableHeightPageSupport() {
        return variableHeightPageSupport;
    }

    public void setVariableHeightPageSupport(Boolean variableHeightPageSupport) {
        this.variableHeightPageSupport = variableHeightPageSupport;
    }

    public Boolean getCreateMarkup() {
        return createMarkup;
    }

    public void setCreateMarkup(Boolean createMarkup) {
        this.createMarkup = createMarkup;
    }

    public Boolean getUse_pdf() {
        return use_pdf;
    }

    public void setUse_pdf(Boolean use_pdf) {
        this.use_pdf = use_pdf;
    }

    public Boolean getUseBrowserCache() {
        return useBrowserCache;
    }

    public void setUseBrowserCache(Boolean useBrowserCache) {
        this.useBrowserCache = useBrowserCache;
    }

    public Boolean getUndoEnabled() {
        return undoEnabled;
    }

    public void setUndoEnabled(Boolean undoEnabled) {
        this.undoEnabled = undoEnabled;
    }

    public Boolean getConvertWordDocumentsCompletely() {
        return convertWordDocumentsCompletely;
    }

    public void setConvertWordDocumentsCompletely(Boolean convertWordDocumentsCompletely) {
        this.convertWordDocumentsCompletely = convertWordDocumentsCompletely;
    }

    public Boolean getIgnoreDocumentAbsence() {
        return ignoreDocumentAbsence;
    }

    public void setIgnoreDocumentAbsence(Boolean ignoreDocumentAbsence) {
        this.ignoreDocumentAbsence = ignoreDocumentAbsence;
    }

    public Boolean getPreloadPagesOnBrowserSide() {
        return preloadPagesOnBrowserSide;
    }

    public void setPreloadPagesOnBrowserSide(Boolean preloadPagesOnBrowserSide) {
        this.preloadPagesOnBrowserSide = preloadPagesOnBrowserSide;
    }

    public Boolean getPrintWithWatermark() {
        return printWithWatermark;
    }

    public void setPrintWithWatermark(Boolean printWithWatermark) {
        this.printWithWatermark = printWithWatermark;
    }

    public Boolean getSupportPageRotation() {
        return supportPageRotation;
    }

    public void setSupportPageRotation(Boolean supportPageRotation) {
        this.supportPageRotation = supportPageRotation;
    }

    public Boolean isRightPanelEnabled() {
        return rightPanelEnabled;
    }

    public void setRightPanelEnabled(boolean rightPanelEnabled) {
        this.rightPanelEnabled = rightPanelEnabled;
    }

    public String getStoreLogic() {
        return storeLogic;
    }

    public void setStoreLogic(String storeLogic) {
        this.storeLogic = storeLogic;
    }
}
