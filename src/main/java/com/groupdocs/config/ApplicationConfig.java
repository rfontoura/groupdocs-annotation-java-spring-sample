package com.groupdocs.config;

import com.groupdocs.annotation.config.ServiceConfigurationBase;
import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksey Permyakov
 */
@Component
public class ApplicationConfig extends ServiceConfigurationBase {
    @Property(key = "groupdocs.annotation.licensePath")
    protected String licensePath;
    @Property(key = "groupdocs.annotation.applicationPath")
    protected String applicationPath;
    @Property(key = "groupdocs.annotation.basePath")
    protected String basePath;
    @Property(key = "groupdocs.annotation.uploadPath")
    private String uploadPath;
    @Property(key = "groupdocs.annotation.dbDriver")
    protected String dbDriver;
    @Property(key = "groupdocs.annotation.dbConnection")
    protected String dbConnection;
    @Property(key = "groupdocs.annotation.useAuthorization")
    protected boolean useAuthorization;
    @Property(key = "groupdocs.annotation.useCache")
    protected boolean useCache;
    @Property(key = "groupdocs.annotation.expirationDate")
    protected int expirationDate;
    @Property(key = "groupdocs.annotation.encryptionKey")
    protected String encryptionKey;
    @Property(key = "groupdocs.annotation.localesPath")
    protected String localesPath;
    @Property(key = "groupdocs.annotation.quality")
    protected int quality;
    @Property(key = "groupdocs.annotation.showThumbnails")
    protected boolean showThumbnails;
    @Property(key = "groupdocs.annotation.openThumbnails")
    protected boolean openThumbnails;
    @Property(key = "groupdocs.annotation.initialZoom")
    protected int initialZoom;
    @Property(key = "groupdocs.annotation.zoomToFitWidth")
    protected boolean zoomToFitWidth;
    @Property(key = "groupdocs.annotation.zoomToFitHeight")
    protected boolean zoomToFitHeight;
    @Property(key = "groupdocs.annotation.width")
    protected int width;
    @Property(key = "groupdocs.annotation.height")
    protected int height;
    @Property(key = "groupdocs.annotation.showPrint")
    protected boolean showPrint;
    @Property(key = "groupdocs.annotation.showZoom")
    protected boolean showZoom;
    @Property(key = "groupdocs.annotation.showPaging")
    protected boolean showPaging;
    @Property(key = "groupdocs.annotation.preloadPagesCount")
    protected int preloadPagesCount;
    @Property(key = "groupdocs.annotation.showHeader")
    protected boolean showHeader;
    @Property(key = "groupdocs.annotation.showFileExplorer")
    protected boolean showFileExplorer;
    @Property(key = "groupdocs.annotation.useEmScaling")
    protected boolean useEmScaling;
    @Property(key = "groupdocs.annotation.enableRightClickMenu")
    protected boolean enableRightClickMenu;
    @Property(key = "groupdocs.annotation.showToolbar")
    protected boolean showToolbar;
    @Property(key = "groupdocs.annotation.enableSidePanel")
    protected boolean enableSidePanel;
    @Property(key = "groupdocs.annotation.scrollOnFocus")
    protected boolean scrollOnFocus;
    @Property(key = "groupdocs.annotation.strikeOutColor")
    protected String strikeOutColor;
    @Property(key = "groupdocs.annotation.enabledTools")
    protected int enabledTools;
    @Property(key = "groupdocs.annotation.connectorPosition")
    protected int connectorPosition;
    @Property(key = "groupdocs.annotation.saveReplyOnFocusLoss")
    protected boolean saveReplyOnFocusLoss;
    @Property(key = "groupdocs.annotation.clickableAnnotations")
    protected boolean clickableAnnotations;
    @Property(key = "groupdocs.annotation.disconnectUncommented")
    protected boolean disconnectUncommented;
    @Property(key = "groupdocs.annotation.strikeoutMode")
    protected int strikeoutMode;
    @Property(key = "groupdocs.annotation.sidebarContainerSelector")
    protected String sidebarContainerSelector;
    @Property(key = "groupdocs.annotation.usePageNumberInUrlHash")
    protected boolean usePageNumberInUrlHash;
    @Property(key = "groupdocs.annotation.textSelectionSynchronousCalculation")
    protected boolean textSelectionSynchronousCalculation;
    @Property(key = "groupdocs.annotation.variableHeightPageSupport")
    protected boolean variableHeightPageSupport;
    @Property(key = "groupdocs.annotation.rightPanelEnabled")
    protected boolean rightPanelEnabled;
    @Property(key = "groupdocs.annotation.createMarkup")
    protected boolean createMarkup;
    @Property(key = "groupdocs.annotation.use_pdf")
    protected boolean use_pdf;
    @Property(key = "groupdocs.annotation.mode")
    protected String mode;
    @Property(key = "groupdocs.annotation.selectionContainerSelector")
    protected String selectionContainerSelector;
    @Property(key = "groupdocs.annotation.graphicsContainerSelector")
    protected String graphicsContainerSelector;
    @Property(key = "groupdocs.annotation.useBrowserCache")
    protected boolean useBrowserCache;
    @Property(key = "groupdocs.annotation.widgetId")
    protected String widgetId;
    @Property(key = "groupdocs.annotation.undoEnabled")
    private boolean undoEnabled;

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

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean isUseAuthorization() {
        return useAuthorization;
    }

    public void setUseAuthorization(boolean useAuthorization) {
        this.useAuthorization = useAuthorization;
    }

    @Override
    public boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }

    @Override
    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
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

    @Override
    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public void setLocalesPath(String localesPath) {
        this.localesPath = localesPath;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public boolean isShowThumbnails() {
        return showThumbnails;
    }

    public void setShowThumbnails(boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    @Override
    public boolean isOpenThumbnails() {
        return openThumbnails;
    }

    public void setOpenThumbnails(boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    @Override
    public int getInitialZoom() {
        return initialZoom;
    }

    public void setInitialZoom(int initialZoom) {
        this.initialZoom = initialZoom;
    }

    @Override
    public boolean isZoomToFitWidth() {
        return zoomToFitWidth;
    }

    public void setZoomToFitWidth(boolean zoomToFitWidth) {
        this.zoomToFitWidth = zoomToFitWidth;
    }

    @Override
    public boolean isZoomToFitHeight() {
        return zoomToFitHeight;
    }

    public void setZoomToFitHeight(boolean zoomToFitHeight) {
        this.zoomToFitHeight = zoomToFitHeight;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean isShowPrint() {
        return showPrint;
    }

    public void setShowPrint(boolean showPrint) {
        this.showPrint = showPrint;
    }

    @Override
    public boolean isShowZoom() {
        return showZoom;
    }

    public void setShowZoom(boolean showZoom) {
        this.showZoom = showZoom;
    }

    @Override
    public boolean isShowPaging() {
        return showPaging;
    }

    public void setShowPaging(boolean showPaging) {
        this.showPaging = showPaging;
    }

    @Override
    public int getPreloadPagesCount() {
        return preloadPagesCount;
    }

    public void setPreloadPagesCount(int preloadPagesCount) {
        this.preloadPagesCount = preloadPagesCount;
    }

    @Override
    public boolean isShowHeader() {
        return showHeader;
    }

    public void setShowHeader(boolean showHeader) {
        this.showHeader = showHeader;
    }

    @Override
    public boolean isShowFileExplorer() {
        return showFileExplorer;
    }

    @Override
    public boolean isUndoEnabled() {
        return undoEnabled;
    }

    public void setUndoEnabled(boolean undoEnabled) {
        this.undoEnabled = undoEnabled;
    }

    public void setShowFileExplorer(boolean showFileExplorer) {
        this.showFileExplorer = showFileExplorer;
    }

    @Override
    public boolean isUseEmScaling() {
        return useEmScaling;
    }

    public void setUseEmScaling(boolean useEmScaling) {
        this.useEmScaling = useEmScaling;
    }

    @Override
    public boolean isEnableRightClickMenu() {
        return enableRightClickMenu;
    }

    public void setEnableRightClickMenu(boolean enableRightClickMenu) {
        this.enableRightClickMenu = enableRightClickMenu;
    }

    @Override
    public boolean isShowToolbar() {
        return showToolbar;
    }

    public void setShowToolbar(boolean showToolbar) {
        this.showToolbar = showToolbar;
    }

    @Override
    public boolean isEnableSidePanel() {
        return enableSidePanel;
    }

    public void setEnableSidePanel(boolean enableSidePanel) {
        this.enableSidePanel = enableSidePanel;
    }

    @Override
    public boolean isScrollOnFocus() {
        return scrollOnFocus;
    }

    public void setScrollOnFocus(boolean scrollOnFocus) {
        this.scrollOnFocus = scrollOnFocus;
    }

    @Override
    public String getStrikeOutColor() {
        return strikeOutColor;
    }

    public void setStrikeOutColor(String strikeOutColor) {
        this.strikeOutColor = strikeOutColor;
    }

    @Override
    public int getEnabledTools() {
        return enabledTools;
    }

    public void setEnabledTools(int enabledTools) {
        this.enabledTools = enabledTools;
    }

    @Override
    public int getConnectorPosition() {
        return connectorPosition;
    }

    public void setConnectorPosition(int connectorPosition) {
        this.connectorPosition = connectorPosition;
    }

    @Override
    public boolean isSaveReplyOnFocusLoss() {
        return saveReplyOnFocusLoss;
    }

    public void setSaveReplyOnFocusLoss(boolean saveReplyOnFocusLoss) {
        this.saveReplyOnFocusLoss = saveReplyOnFocusLoss;
    }

    @Override
    public boolean isClickableAnnotations() {
        return clickableAnnotations;
    }

    public void setClickableAnnotations(boolean clickableAnnotations) {
        this.clickableAnnotations = clickableAnnotations;
    }

    @Override
    public boolean isDisconnectUncommented() {
        return disconnectUncommented;
    }

    public void setDisconnectUncommented(boolean disconnectUncommented) {
        this.disconnectUncommented = disconnectUncommented;
    }

    @Override
    public int getStrikeoutMode() {
        return strikeoutMode;
    }

    public void setStrikeoutMode(int strikeoutMode) {
        this.strikeoutMode = strikeoutMode;
    }

    @Override
    public String getSidebarContainerSelector() {
        return sidebarContainerSelector;
    }

    public void setSidebarContainerSelector(String sidebarContainerSelector) {
        this.sidebarContainerSelector = sidebarContainerSelector;
    }

    @Override
    public boolean isUsePageNumberInUrlHash() {
        return usePageNumberInUrlHash;
    }

    public void setUsePageNumberInUrlHash(boolean usePageNumberInUrlHash) {
        this.usePageNumberInUrlHash = usePageNumberInUrlHash;
    }

    @Override
    public boolean isTextSelectionSynchronousCalculation() {
        return textSelectionSynchronousCalculation;
    }

    public void setTextSelectionSynchronousCalculation(boolean textSelectionSynchronousCalculation) {
        this.textSelectionSynchronousCalculation = textSelectionSynchronousCalculation;
    }

    @Override
    public boolean isVariableHeightPageSupport() {
        return variableHeightPageSupport;
    }

    public void setVariableHeightPageSupport(boolean variableHeightPageSupport) {
        this.variableHeightPageSupport = variableHeightPageSupport;
    }

    @Override
    public boolean isRightPanelEnabled() {
        return rightPanelEnabled;
    }

    public void setRightPanelEnabled(boolean rightPanelEnabled) {
        this.rightPanelEnabled = rightPanelEnabled;
    }

    @Override
    public boolean isCreateMarkup() {
        return createMarkup;
    }

    public void setCreateMarkup(boolean createMarkup) {
        this.createMarkup = createMarkup;
    }

    @Override
    public boolean isUse_pdf() {
        return use_pdf;
    }

    public void setUse_pdf(boolean use_pdf) {
        this.use_pdf = use_pdf;
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
    public boolean isUseBrowserCache() {
        return useBrowserCache;
    }

    public void setUseBrowserCache(boolean useBrowserCache) {
        this.useBrowserCache = useBrowserCache;
    }

    @Override
    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

}
