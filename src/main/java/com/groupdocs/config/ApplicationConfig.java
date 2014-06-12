package com.groupdocs.config;

import com.groupdocs.viewer.config.ServiceConfigurationBase;
import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksey Permyakov
 */
@Component
public class ApplicationConfig implements ServiceConfigurationBase {
    @Property(key = "groupdocs.annotation.licensePath")
    protected String licensePath;
    @Property(key = "groupdocs.annotation.applicationPath")
    protected String applicationPath;
    @Property(key = "groupdocs.annotation.basePath")
    protected String basePath;
    @Property(key = "groupdocs.annotation.useAuthorization")
    protected boolean useAuthorization;
    @Property(key = "groupdocs.annotation.useCache")
    protected boolean useCache;
    @Property(key = "groupdocs.annotation.expirationDate")
    protected int expirationDate;
    @Property(key = "groupdocs.annotation.encryptionKey")
    protected String encryptionKey;
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
    @Property(key = "groupdocs.annotation.backgroundColor")
    protected String backgroundColor;
    @Property(key = "groupdocs.annotation.showFolderBrowser")
    protected boolean showFolderBrowser;
    @Property(key = "groupdocs.annotation.showPrint")
    protected boolean showPrint;
    @Property(key = "groupdocs.annotation.showDownload")
    protected boolean showDownload;
    @Property(key = "groupdocs.annotation.showZoom")
    protected boolean showZoom;
    @Property(key = "groupdocs.annotation.showPaging")
    protected boolean showPaging;
    @Property(key = "groupdocs.annotation.showViewerStyleControl")
    protected boolean showViewerStyleControl;
    @Property(key = "groupdocs.annotation.showSearch")
    protected boolean showSearch;
    @Property(key = "groupdocs.annotation.preloadPagesCount")
    protected int preloadPagesCount;
    @Property(key = "groupdocs.annotation.viewerStyle")
    protected int viewerStyle;
    @Property(key = "groupdocs.annotation.supportTextSelection")
    protected boolean supportTextSelection;
    @Property(key = "groupdocs.annotation.usePdfPrinting")
    protected boolean usePdfPrinting;
    @Property(key = "groupdocs.annotation.toolbarButtonsBoxShadowStyle")
    protected String toolbarButtonsBoxShadowStyle;
    @Property(key = "groupdocs.annotation.toolbarButtonsBoxShadowHoverStyle")
    protected String toolbarButtonsBoxShadowHoverStyle;
    @Property(key = "groupdocs.annotation.thumbnailsContainerBackgroundColor")
    protected String thumbnailsContainerBackgroundColor;
    @Property(key = "groupdocs.annotation.thumbnailsContainerBorderRightColor")
    protected String thumbnailsContainerBorderRightColor;
    @Property(key = "groupdocs.annotation.toolbarBorderBottomColor")
    protected String toolbarBorderBottomColor;
    @Property(key = "groupdocs.annotation.toolbarInputFieldBorderColor")
    protected String toolbarInputFieldBorderColor;
    @Property(key = "groupdocs.annotation.toolbarButtonBorderColor")
    protected String toolbarButtonBorderColor;
    @Property(key = "groupdocs.annotation.toolbarButtonBorderHoverColor")
    protected String toolbarButtonBorderHoverColor;
    @Property(key = "groupdocs.annotation.thumbnailsContainerWidth")
    protected int thumbnailsContainerWidth;
    @Property(key = "groupdocs.annotation.showDownloadErrorsInPopup")
    protected boolean showDownloadErrorsInPopup;
    @Property(key = "groupdocs.annotation.showImageWidth")
    protected boolean showImageWidth;
    @Property(key = "groupdocs.annotation.showHeader")
    protected boolean showHeader;
    @Property(key = "groupdocs.annotation.minimumImageWidth")
    protected int minimumImageWidth;
    @Property(key = "groupdocs.annotation.enableStandardErrorHandling")
    protected boolean enableStandardErrorHandling;
    @Property(key = "groupdocs.annotation.useHtmlBasedEngine")
    protected boolean useHtmlBasedEngine;
    @Property(key = "groupdocs.annotation.useImageBasedPrinting")
    protected boolean useImageBasedPrinting;
    @Property(key = "groupdocs.annotation.downloadPdfFile")
    protected boolean downloadPdfFile;
    @Property(key = "groupdocs.annotation.searchForSeparateWords")
    protected boolean searchForSeparateWords;
    @Property(key = "groupdocs.annotation.preventTouchEventsBubbling")
    protected boolean preventTouchEventsBubbling;
    @Property(key = "groupdocs.annotation.useInnerThumbnails")
    protected boolean useInnerThumbnails;
    @Property(key = "groupdocs.annotation.watermarkText")
    protected String watermarkText;
    @Property(key = "groupdocs.annotation.watermarkColor")
    protected String watermarkColor;
    @Property(key = "groupdocs.annotation.supportPageReordering")
    protected boolean supportPageReordering;
    @Property(key = "groupdocs.annotation.onlyShrinkLargePages")
    protected boolean onlyShrinkLargePages;
    @Property(key = "groupdocs.annotation.searchHighlightColor")
    protected String searchHighlightColor;
    @Property(key = "groupdocs.annotation.currentSearchHighlightColor")
    protected String currentSearchHighlightColor;
    @Property(key = "groupdocs.annotation.treatPhrasesInDoubleQuotesAsExactPhrases")
    protected boolean treatPhrasesInDoubleQuotesAsExactPhrases;
    @Property(key = "groupdocs.annotation.usePngImagesForHtmlBasedEngine")
    protected boolean usePngImagesForHtmlBasedEngine;
    @Property(key = "groupdocs.annotation.showOnePageInRow")
    protected boolean showOnePageInRow;
    @Property(key = "groupdocs.annotation.loadAllPagesOnSearch")
    protected boolean loadAllPagesOnSearch;
    @Property(key = "groupdocs.annotation.useEmScaling")
    protected boolean useEmScaling;

    @Property(key = "groupdocs.annotation.showFileExplorer")
    protected boolean showFileExplorer;
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
    @Property(key = "groupdocs.annotation.useJavaScriptDocumentDescription")
    protected boolean useJavaScriptDocumentDescription;
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
    @Property(key = "groupdocs.annotation.widgetId")
    protected String widgetId;
    @Property(key = "groupdocs.annotation.useBrowserCache")
    protected boolean useBrowserCache;

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public boolean isUseAuthorization() {
        return useAuthorization;
    }

    public void setUseAuthorization(boolean useAuthorization) {
        this.useAuthorization = useAuthorization;
    }

    public boolean isUseCache() {
        return useCache;
    }

    @Override
    public boolean isUseBrowserCache() {
        return useBrowserCache;
    }

    public void setUseBrowserCache(boolean useBrowserCache) {
        this.useBrowserCache = useBrowserCache;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public boolean isShowThumbnails() {
        return showThumbnails;
    }

    public void setShowThumbnails(boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    public boolean isOpenThumbnails() {
        return openThumbnails;
    }

    public void setOpenThumbnails(boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    public int getInitialZoom() {
        return initialZoom;
    }

    public void setInitialZoom(int initialZoom) {
        this.initialZoom = initialZoom;
    }

    public boolean isZoomToFitWidth() {
        return zoomToFitWidth;
    }

    public void setZoomToFitWidth(boolean zoomToFitWidth) {
        this.zoomToFitWidth = zoomToFitWidth;
    }

    public boolean isZoomToFitHeight() {
        return zoomToFitHeight;
    }

    public void setZoomToFitHeight(boolean zoomToFitHeight) {
        this.zoomToFitHeight = zoomToFitHeight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isShowFolderBrowser() {
        return showFolderBrowser;
    }

    public void setShowFolderBrowser(boolean showFolderBrowser) {
        this.showFolderBrowser = showFolderBrowser;
    }

    public boolean isShowPrint() {
        return showPrint;
    }

    public void setShowPrint(boolean showPrint) {
        this.showPrint = showPrint;
    }

    public boolean isShowDownload() {
        return showDownload;
    }

    public void setShowDownload(boolean showDownload) {
        this.showDownload = showDownload;
    }

    public boolean isShowZoom() {
        return showZoom;
    }

    public void setShowZoom(boolean showZoom) {
        this.showZoom = showZoom;
    }

    public boolean isShowPaging() {
        return showPaging;
    }

    public void setShowPaging(boolean showPaging) {
        this.showPaging = showPaging;
    }

    public boolean isShowViewerStyleControl() {
        return showViewerStyleControl;
    }

    public void setShowViewerStyleControl(boolean showViewerStyleControl) {
        this.showViewerStyleControl = showViewerStyleControl;
    }

    public boolean isShowSearch() {
        return showSearch;
    }

    public void setShowSearch(boolean showSearch) {
        this.showSearch = showSearch;
    }

    public int getPreloadPagesCount() {
        return preloadPagesCount;
    }

    public void setPreloadPagesCount(int preloadPagesCount) {
        this.preloadPagesCount = preloadPagesCount;
    }

    public int getViewerStyle() {
        return viewerStyle;
    }

    public void setViewerStyle(int viewerStyle) {
        this.viewerStyle = viewerStyle;
    }

    public boolean isSupportTextSelection() {
        return supportTextSelection;
    }

    public void setSupportTextSelection(boolean supportTextSelection) {
        this.supportTextSelection = supportTextSelection;
    }

    public boolean isUsePdfPrinting() {
        return usePdfPrinting;
    }

    public void setUsePdfPrinting(boolean usePdfPrinting) {
        this.usePdfPrinting = usePdfPrinting;
    }

    public String getToolbarButtonsBoxShadowStyle() {
        return toolbarButtonsBoxShadowStyle;
    }

    public void setToolbarButtonsBoxShadowStyle(String toolbarButtonsBoxShadowStyle) {
        this.toolbarButtonsBoxShadowStyle = toolbarButtonsBoxShadowStyle;
    }

    public String getToolbarButtonsBoxShadowHoverStyle() {
        return toolbarButtonsBoxShadowHoverStyle;
    }

    public void setToolbarButtonsBoxShadowHoverStyle(String toolbarButtonsBoxShadowHoverStyle) {
        this.toolbarButtonsBoxShadowHoverStyle = toolbarButtonsBoxShadowHoverStyle;
    }

    public String getThumbnailsContainerBackgroundColor() {
        return thumbnailsContainerBackgroundColor;
    }

    public void setThumbnailsContainerBackgroundColor(String thumbnailsContainerBackgroundColor) {
        this.thumbnailsContainerBackgroundColor = thumbnailsContainerBackgroundColor;
    }

    public String getThumbnailsContainerBorderRightColor() {
        return thumbnailsContainerBorderRightColor;
    }

    public void setThumbnailsContainerBorderRightColor(String thumbnailsContainerBorderRightColor) {
        this.thumbnailsContainerBorderRightColor = thumbnailsContainerBorderRightColor;
    }

    public String getToolbarBorderBottomColor() {
        return toolbarBorderBottomColor;
    }

    public void setToolbarBorderBottomColor(String toolbarBorderBottomColor) {
        this.toolbarBorderBottomColor = toolbarBorderBottomColor;
    }

    public String getToolbarInputFieldBorderColor() {
        return toolbarInputFieldBorderColor;
    }

    public void setToolbarInputFieldBorderColor(String toolbarInputFieldBorderColor) {
        this.toolbarInputFieldBorderColor = toolbarInputFieldBorderColor;
    }

    public String getToolbarButtonBorderColor() {
        return toolbarButtonBorderColor;
    }

    public void setToolbarButtonBorderColor(String toolbarButtonBorderColor) {
        this.toolbarButtonBorderColor = toolbarButtonBorderColor;
    }

    public String getToolbarButtonBorderHoverColor() {
        return toolbarButtonBorderHoverColor;
    }

    public void setToolbarButtonBorderHoverColor(String toolbarButtonBorderHoverColor) {
        this.toolbarButtonBorderHoverColor = toolbarButtonBorderHoverColor;
    }

    public int getThumbnailsContainerWidth() {
        return thumbnailsContainerWidth;
    }

    public void setThumbnailsContainerWidth(int thumbnailsContainerWidth) {
        this.thumbnailsContainerWidth = thumbnailsContainerWidth;
    }

    public boolean isShowDownloadErrorsInPopup() {
        return showDownloadErrorsInPopup;
    }

    public void setShowDownloadErrorsInPopup(boolean showDownloadErrorsInPopup) {
        this.showDownloadErrorsInPopup = showDownloadErrorsInPopup;
    }

    public boolean isShowImageWidth() {
        return showImageWidth;
    }

    public void setShowImageWidth(boolean showImageWidth) {
        this.showImageWidth = showImageWidth;
    }

    public boolean isShowHeader() {
        return showHeader;
    }

    public void setShowHeader(boolean showHeader) {
        this.showHeader = showHeader;
    }

    public int getMinimumImageWidth() {
        return minimumImageWidth;
    }

    public void setMinimumImageWidth(int minimumImageWidth) {
        this.minimumImageWidth = minimumImageWidth;
    }

    public boolean isEnableStandardErrorHandling() {
        return enableStandardErrorHandling;
    }

    public void setEnableStandardErrorHandling(boolean enableStandardErrorHandling) {
        this.enableStandardErrorHandling = enableStandardErrorHandling;
    }

    public boolean isUseHtmlBasedEngine() {
        return useHtmlBasedEngine;
    }

    public void setUseHtmlBasedEngine(boolean useHtmlBasedEngine) {
        this.useHtmlBasedEngine = useHtmlBasedEngine;
    }

    public boolean isUseImageBasedPrinting() {
        return useImageBasedPrinting;
    }

    public void setUseImageBasedPrinting(boolean useImageBasedPrinting) {
        this.useImageBasedPrinting = useImageBasedPrinting;
    }

    public boolean isDownloadPdfFile() {
        return downloadPdfFile;
    }

    public void setDownloadPdfFile(boolean downloadPdfFile) {
        this.downloadPdfFile = downloadPdfFile;
    }

    public boolean isSearchForSeparateWords() {
        return searchForSeparateWords;
    }

    public void setSearchForSeparateWords(boolean searchForSeparateWords) {
        this.searchForSeparateWords = searchForSeparateWords;
    }

    public boolean isPreventTouchEventsBubbling() {
        return preventTouchEventsBubbling;
    }

    public void setPreventTouchEventsBubbling(boolean preventTouchEventsBubbling) {
        this.preventTouchEventsBubbling = preventTouchEventsBubbling;
    }

    public boolean isUseInnerThumbnails() {
        return useInnerThumbnails;
    }

    public void setUseInnerThumbnails(boolean useInnerThumbnails) {
        this.useInnerThumbnails = useInnerThumbnails;
    }

    public String getWatermarkText() {
        return watermarkText;
    }

    public void setWatermarkText(String watermarkText) {
        this.watermarkText = watermarkText;
    }

    public String getWatermarkColor() {
        return watermarkColor;
    }

    public void setWatermarkColor(String watermarkColor) {
        this.watermarkColor = watermarkColor;
    }

    public boolean isSupportPageReordering() {
        return supportPageReordering;
    }

    public void setSupportPageReordering(boolean supportPageReordering) {
        this.supportPageReordering = supportPageReordering;
    }

    public boolean isOnlyShrinkLargePages() {
        return onlyShrinkLargePages;
    }

    public void setOnlyShrinkLargePages(boolean onlyShrinkLargePages) {
        this.onlyShrinkLargePages = onlyShrinkLargePages;
    }

    public String getSearchHighlightColor() {
        return searchHighlightColor;
    }

    public void setSearchHighlightColor(String searchHighlightColor) {
        this.searchHighlightColor = searchHighlightColor;
    }

    public String getCurrentSearchHighlightColor() {
        return currentSearchHighlightColor;
    }

    public void setCurrentSearchHighlightColor(String currentSearchHighlightColor) {
        this.currentSearchHighlightColor = currentSearchHighlightColor;
    }

    public boolean isTreatPhrasesInDoubleQuotesAsExactPhrases() {
        return treatPhrasesInDoubleQuotesAsExactPhrases;
    }

    public void setTreatPhrasesInDoubleQuotesAsExactPhrases(boolean treatPhrasesInDoubleQuotesAsExactPhrases) {
        this.treatPhrasesInDoubleQuotesAsExactPhrases = treatPhrasesInDoubleQuotesAsExactPhrases;
    }

    public boolean isUsePngImagesForHtmlBasedEngine() {
        return usePngImagesForHtmlBasedEngine;
    }

    public void setUsePngImagesForHtmlBasedEngine(boolean usePngImagesForHtmlBasedEngine) {
        this.usePngImagesForHtmlBasedEngine = usePngImagesForHtmlBasedEngine;
    }

    public boolean isShowOnePageInRow() {
        return showOnePageInRow;
    }

    public void setShowOnePageInRow(boolean showOnePageInRow) {
        this.showOnePageInRow = showOnePageInRow;
    }

    public boolean isLoadAllPagesOnSearch() {
        return loadAllPagesOnSearch;
    }

    public void setLoadAllPagesOnSearch(boolean loadAllPagesOnSearch) {
        this.loadAllPagesOnSearch = loadAllPagesOnSearch;
    }

    public boolean isUseEmScaling() {
        return useEmScaling;
    }

    public void setUseEmScaling(boolean useEmScaling) {
        this.useEmScaling = useEmScaling;
    }

    public boolean isEnableRightClickMenu() {
        return enableRightClickMenu;
    }

    public void setEnableRightClickMenu(boolean enableRightClickMenu) {
        this.enableRightClickMenu = enableRightClickMenu;
    }

    public boolean isShowToolbar() {
        return showToolbar;
    }

    public void setShowToolbar(boolean showToolbar) {
        this.showToolbar = showToolbar;
    }

    public boolean isEnableSidePanel() {
        return enableSidePanel;
    }

    public void setEnableSidePanel(boolean enableSidePanel) {
        this.enableSidePanel = enableSidePanel;
    }

    public boolean isScrollOnFocus() {
        return scrollOnFocus;
    }

    public void setScrollOnFocus(boolean scrollOnFocus) {
        this.scrollOnFocus = scrollOnFocus;
    }

    public String getStrikeOutColor() {
        return strikeOutColor;
    }

    public void setStrikeOutColor(String strikeOutColor) {
        this.strikeOutColor = strikeOutColor;
    }

    public int getEnabledTools() {
        return enabledTools;
    }

    public void setEnabledTools(int enabledTools) {
        this.enabledTools = enabledTools;
    }

    public int getConnectorPosition() {
        return connectorPosition;
    }

    public void setConnectorPosition(int connectorPosition) {
        this.connectorPosition = connectorPosition;
    }

    public boolean isSaveReplyOnFocusLoss() {
        return saveReplyOnFocusLoss;
    }

    public void setSaveReplyOnFocusLoss(boolean saveReplyOnFocusLoss) {
        this.saveReplyOnFocusLoss = saveReplyOnFocusLoss;
    }

    public boolean isClickableAnnotations() {
        return clickableAnnotations;
    }

    public void setClickableAnnotations(boolean clickableAnnotations) {
        this.clickableAnnotations = clickableAnnotations;
    }

    public boolean isDisconnectUncommented() {
        return disconnectUncommented;
    }

    public void setDisconnectUncommented(boolean disconnectUncommented) {
        this.disconnectUncommented = disconnectUncommented;
    }

    public int getStrikeoutMode() {
        return strikeoutMode;
    }

    public void setStrikeoutMode(int strikeoutMode) {
        this.strikeoutMode = strikeoutMode;
    }

    public String getSidebarContainerSelector() {
        return sidebarContainerSelector;
    }

    public void setSidebarContainerSelector(String sidebarContainerSelector) {
        this.sidebarContainerSelector = sidebarContainerSelector;
    }

    public boolean isUsePageNumberInUrlHash() {
        return usePageNumberInUrlHash;
    }

    public void setUsePageNumberInUrlHash(boolean usePageNumberInUrlHash) {
        this.usePageNumberInUrlHash = usePageNumberInUrlHash;
    }

    public boolean isTextSelectionSynchronousCalculation() {
        return textSelectionSynchronousCalculation;
    }

    public void setTextSelectionSynchronousCalculation(boolean textSelectionSynchronousCalculation) {
        this.textSelectionSynchronousCalculation = textSelectionSynchronousCalculation;
    }

    public boolean isVariableHeightPageSupport() {
        return variableHeightPageSupport;
    }

    public void setVariableHeightPageSupport(boolean variableHeightPageSupport) {
        this.variableHeightPageSupport = variableHeightPageSupport;
    }

    public boolean isUseJavaScriptDocumentDescription() {
        return useJavaScriptDocumentDescription;
    }

    public void setUseJavaScriptDocumentDescription(boolean useJavaScriptDocumentDescription) {
        this.useJavaScriptDocumentDescription = useJavaScriptDocumentDescription;
    }

    public boolean isRightPanelEnabled() {
        return rightPanelEnabled;
    }

    public void setRightPanelEnabled(boolean rightPanelEnabled) {
        this.rightPanelEnabled = rightPanelEnabled;
    }

    public boolean isCreateMarkup() {
        return createMarkup;
    }

    public void setCreateMarkup(boolean createMarkup) {
        this.createMarkup = createMarkup;
    }

    public boolean isUse_pdf() {
        return use_pdf;
    }

    public void setUse_pdf(boolean use_pdf) {
        this.use_pdf = use_pdf;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSelectionContainerSelector() {
        return selectionContainerSelector;
    }

    public void setSelectionContainerSelector(String selectionContainerSelector) {
        this.selectionContainerSelector = selectionContainerSelector;
    }

    public String getGraphicsContainerSelector() {
        return graphicsContainerSelector;
    }

    public void setGraphicsContainerSelector(String graphicsContainerSelector) {
        this.graphicsContainerSelector = graphicsContainerSelector;
    }

    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    public boolean isShowFileExplorer() {
        return showFileExplorer;
    }

    public void setShowFileExplorer(boolean showFileExplorer) {
        this.showFileExplorer = showFileExplorer;
    }
}
