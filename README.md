##GroupDocs.Annotation for Java
####Spring Sample 1.8.0
![Alt text](https://media.licdn.com/media/p/7/005/059/258/39b2da3.png "Optional title")

<br/><br/>

How-to install/run
------

#####Windows
1. Download GroupDocs.Annotation for Java library http://groupdocs.com/java/document-annotation-library
2. Install GroupDocs.Annotation for Java library into local maven repository http://groupdocs.com/docs/display/annotationjava/GroupDocs.Annotation+for+Java+-+Installation
3. Download sample sources to any directory.
4. Open file `src\main\resources\application.properties` and update configuration (for example update groupdocs.viewer.basePath to set the path to the storage folder).
5. Run file `run.bat` by double click to start sample application.
6. Open URL `http://127.0.0.1:8080/document-annotation/` in your browser, make sure that port 8080 is free (you can change port number in your tomcat configuration).
<br/><br/>

#####Linux
1. Download GroupDocs.Annotation for Java library http://groupdocs.com/java/document-annotation-library
2. Install GroupDocs.Annotation for Java library into local maven repository http://groupdocs.com/docs/display/annotationjava/GroupDocs.Annotation+for+Java+-+Installation
3. Download sample sources to any directory.
4. Open file `src\main\resources\application.properties` and update configuration (for example update groupdocs.viewer.basePath to set the path to the storage folder).
5. Run file `run.sh` by double click to start sample application.
6. Open URL `http://127.0.0.1:8080/document-annotation/` in your browser, make sure that port 8080 is free (you can change port number in your tomcat configuration).
<br/><br/>

#####MacOS
1. Download GroupDocs.Annotation for Java library http://groupdocs.com/java/document-annotation-library
2. Install GroupDocs.Annotation for Java library into local maven repository http://groupdocs.com/docs/display/annotationjava/GroupDocs.Annotation+for+Java+-+Installation
3. Download sample sources to any directory.
4. Open file `src\main\resources\application.properties` and update configuration (for example update groupdocs.viewer.basePath to set the path to the storage folder).
5. Run file `run.command` by double click to start sample application.
6. Open URL `http://127.0.0.1:8080/document-annotation/` in your browser, make sure that port 8080 is free (you can change port number in your tomcat configuration).
<br/><br/><br/><br/>

How to view/open file documents
-------------------------------
1. Go to http://127.0.0.1:8080/view?file=fileId
2. Go to http://127.0.0.1:8080/view?file=path_to_file_from_root_dir
3. Go to http://127.0.0.1:8080/view?file=url_to_file
4. Go to http://127.0.0.1:8080/view?tokenId=tokenId
<br/><br/><br/><br/>

Context path
-------------------------------
For change context path when run using tomcat
* Change context [http://screencast.com/t/FXrXxDGR](http://screencast.com/t/FXrXxDGR)
* Remove context [http://screencast.com/t/jCgWYIcOzJg](http://screencast.com/t/jCgWYIcOzJg)

For change context path when run using maven (`/document-annotation`)
* Update `path` attribute in file `src/main/webapp/META-INF/context.xml`
* Update `path` in tomcat7-maven-plugin (file `pom.xml`)
* Update `groupdocs.annotation.applicationPath` parameter in `src/main/resources/application.properties`
<br/><br/><br/><br/>

Description
---------------
A flexible library that lets end users annotate Microsoft Office, PDF and other documents within your Java applications. The library comes with a comprehensive set of markup tools, which allow end users to highlight, strike through, and comment text and images. Annotated documents can be printed out and exported to PDF or Microsoft Word.
