<%-- 
    Document   : upload-result
    Created on : Oct 8, 2016, 10:33:15 PM
    Author     : Igor Gayvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result of uploading file</title>
    </head>
    <body>
        <h2>${requestScope.message}</h2>
        <table>
            <tbody>
                <c:forEach var="uploadFile" items="${listUploadFile}" >
                    <tr>
                        <td align="right"><b>ID:</b></td><td><c:out value="${uploadFile.fileId}" /></td>
                    </tr>
                    <tr>
                        <td align="right"><b>Name:</b></td><td><c:out value="${uploadFile.fileName}" /></td>
                    </tr>
                    <tr>
                        <td align="right"><b>Path:</b></td><td><c:out value="${uploadFile.filePath}" /></td>
                    </tr>
                    <tr>
                        <td align="right"><b>UUID:</b></td><td><c:out value="${uploadFile.fileUUID}" /></td>
                    </tr>
                    <tr>
                        <td align="right"><b>md5:</b></td><td><c:out value="${uploadFile.fileMd5}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>