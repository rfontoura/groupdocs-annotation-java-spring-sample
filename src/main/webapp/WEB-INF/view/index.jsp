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
        ${groupdocsScripts}
    </body>
</html>
