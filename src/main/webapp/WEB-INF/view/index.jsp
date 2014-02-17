<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>GroupDocs Annotation for Java Sample</title>
        ${groupdocsHeader}
    </head> 
    <body>
        <div id="annotation-widget" style="width:${width}px;height:${height}px;overflow:hidden;position:relative;margin-bottom:20px;background-color:gray;border:1px solid #ccc;"></div>
        <script type="text/javascript">
            $(function () {
                var annotationWidget = $('#annotation-widget').groupdocsAnnotation({
                    width: ${width},
                    height: ${height},
                    fileId: '${filePath}',
                    docViewerId: 'doc_viewer1',
                    quality: 90,
                    enableRightClickMenu: true,
                    showHeader: ${showHeader},
                    showZoom: ${showZoom},
                    showPaging: ${showPaging},
                    showPrint: ${showPrint},
                    showFileExplorer: false,
                    showThumbnails: ${showThumbnails},
                    openThumbnails: ${openThumbnails},
                    zoomToFitWidth: false,
                    zoomToFitHeight: false,
                    initialZoom: 100,
                    preloadPagesCount: 0,
                    enableSidePanel: true,
                    strikeOutColor: '',
                    enabledTools: 127,
                    sideboarContainerSelector: 'div.comments_sidebar_wrapper',
                    usePageNumberInUrlHash: false,
                    textSelectionSynchronousCalculation: true,
                    variableHeightPageSupport: true,
                    useJavaScriptDocumentDescription: true,
                    isRightPanelEnabled: true,
                    createMarkup: true,
                    use_pdf: 'true',
                    _mode: 'annotatedDocument',
                    selectionContainerSelector: "[name='selection-content']",

                    graphicsContainerSelector: '.annotationsContainer',

                    userName: '${userName}',userId: '${userGuid}'

                });
                var annotationsViewer = $(annotationWidget).groupdocsAnnotation('getViewer');
                var annotationsViewerVM = $(annotationsViewer).groupdocsAnnotationViewer('getViewModel');


                var commentModePanel = $(annotationWidget).find('div.embed_annotation_tools');
                commentModePanel.css('margin-right', 0);

                commentModePanel.draggable({
                    scroll: false,
                    handle: '.tools_dots',
                    containment: 'body',
                    appendTo: 'body'
                });

                $(annotationWidget).find('.tool_field').click(function () {
                    var toolFields = $(annotationWidget).find('.tool_field');
                    if (toolFields.hasClass('active')) {
                        $(toolFields.removeClass('active'));
                    };
                    $(this).addClass('active');
                });

                $(annotationWidget).find('.header_tools_icon').hover(
                        function () { $(this).find('.tooltip_on_hover').css('display', 'block'); },
                        function () { $(this).find('.tooltip_on_hover').css('display', 'none'); });



                $('#annotation-widget .comments_togle_btn').click(function () { flipPanels(true); });

                $(annotationWidget).find('.comments_scroll').tinyscrollbar({ sizethumb: 50 });
                $(annotationWidget).find('.comments_scroll_2').tinyscrollbar({ sizethumb: 50 });

                var annotationIconsWrapper = $(annotationWidget).find('.annotation_icons_wrapper');
                var annotationIconsWrapperParent = annotationIconsWrapper.parent()[0];
                var annotationIconsWrapperParentScrollTop;

                annotationsViewer.bind('onDocumentLoadComplete', function (e, data) {
                    annotationsViewerVM.listAnnotations();
                    annotationsViewerVM.setHandToolMode();

                    annotationIconsWrapper.height($(annotationsViewer).find('.pages_container').height());
                    annotationIconsWrapperParent.scrollTop = annotationIconsWrapperParentScrollTop;

                    window.setTimeout(resizeSidebar, 10);
                });

                annotationsViewer.bind('onDocViewScrollPositionSet', function (e, data) {
                    annotationIconsWrapper.parent()[0].scrollTop = data.position;
                } .bind(this));

                annotationsViewer.bind('onBeforeScrollDocView onDocViewScrollPositionSet', function (e, data) {
                    if (annotationIconsWrapperParent.scrollTop != data.position) {
                        annotationIconsWrapperParent.scrollTop = data.position;
                        annotationIconsWrapperParentScrollTop = data.position;
                    }
                } .bind(this));

                function flipPanels(togglePanels) {
                    var docViewer = $(annotationsViewer)[0];
                    var annotationIconsPanelVisible = $(annotationWidget).find('.comments_sidebar_collapsed').is(':visible');

                    function setIconsPanelScrollTop() {
                        if (!annotationIconsPanelVisible)
                            annotationIconsWrapperParent.scrollTop = docViewer.scrollTop;
                    }

                    function redrawLinesAndCalculateZoom() {
                        setIconsPanelScrollTop();

                        if (togglePanels)
                            annotationsViewerVM.redrawConnectingLines(!annotationIconsPanelVisible);
                        else {
                            annotationsViewerVM.resizePagesToWindowSize();
                            var selectableElement = annotationsViewerVM.getSelectable();

                            if (selectableElement != null) {
                                var selectable = (selectableElement.data('ui-dvselectable') || selectableElement.data('dvselectable'));
                                selectable.initStorage();
                            }

                            annotationsViewerVM.redrawWorkingArea();
                        }
                    }

                    if (togglePanels) {
                        if (!annotationIconsPanelVisible) {
                            redrawLinesAndCalculateZoom();
                        }

                        var setIntervalId = window.setInterval(function () {
                            setIconsPanelScrollTop();
                        }, 50);

                        $(annotationWidget).find('.comments_sidebar_collapsed').toggle('slide', { direction: 'right' }, 400, function () {
                            clearInterval(setIntervalId);
                            setIconsPanelScrollTop();
                        });

                        $(annotationWidget).find('.comments_sidebar_expanded').toggle('slide', { direction: 'right' }, 400,
                                function () {
                                    if (annotationIconsPanelVisible)
                                        redrawLinesAndCalculateZoom();
                                    else
                                        setIconsPanelScrollTop();

                                    //window.setZoomWhenTogglePanel();
                                });
                    }
                    else
                        redrawLinesAndCalculateZoom();

                    $(annotationWidget).find('.comments_scroll').tinyscrollbar_update('relative');
                    $(annotationWidget).find('.comments_scroll_2').tinyscrollbar_update('relative');
                }

                $(window).resize(function () {
                    flipPanels(false);
                    resizeSidebar();
                });

                resizeSidebar();



                function resizeSidebar() {
                    var containerHeight = $('#annotation-widget .doc_viewer').height();
                    $(annotationWidget).find('.comments_content').css({ 'height': (containerHeight - 152) + 'px' });
                    $(annotationWidget).find('.comments_scroll').css({ 'height': (containerHeight - 152) + 'px' });
                    $(annotationWidget).find('.comments_scroll .viewport').css({ 'height': (containerHeight - 172) + 'px' });
                    $(annotationWidget).find('.comments_sidebar_collapsed').css({ 'height': (containerHeight - 50) + 'px' });
                    $(annotationWidget).find('.comments_scroll').tinyscrollbar_update('relative');
                    $(annotationWidget).find('.comments_scroll_2').css({ 'height': (containerHeight - 152) + 'px' });
                    $(annotationWidget).find('.comments_scroll_2 .viewport').css({ 'height': (containerHeight - 152) + 'px' });
                    $(annotationWidget).find('.comments_scroll_2').tinyscrollbar_update('relative');
                }

                $('html').click(function () {
                    if ($(annotationWidget).find('.dropdown_menu_button').hasClass('active')) {
                        $(annotationWidget).find('.dropdown_menu_button.active').next('.dropdown_menu').hide('blind', 'fast');
                        $(annotationWidget).find('.dropdown_menu_button.active').removeClass('active');
                    }
                });

            });
        </script>
    </body>
</html>
