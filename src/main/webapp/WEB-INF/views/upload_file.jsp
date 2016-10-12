<%-- 
    Document   : ulpoad_file
    Created on : Oct 8, 2016, 10:31:39 PM
    Author     : Igor Gayvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select file for upload</title>
    </head>
    <body>
    <center>
        <h1>File Upload</h1>
        <form method="post" enctype="multipart/form-data">
            Select file to upload: <input type="file" name="file"  multiple/><br />
            <br /> <input type="submit" value="Upload" />
        </form>
    </center>
</body>
</html>
