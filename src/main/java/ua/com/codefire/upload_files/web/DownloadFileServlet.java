/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.upload_files.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.upload_files.dao.IUploadFileDao;
import ua.com.codefire.upload_files.dao.UploadFileDaoImpl;
import ua.com.codefire.upload_files.dao.models.UploadFile;

/**
 * http://www.codejava.net/java-ee/servlet/java-servlet-download-file-example
 *
 * @author Igor Gayvan
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {

    private static final String SAVE_DIR = "uploadFiles";

    private final IUploadFileDao dao = new UploadFileDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int fileId = 0;

        String param;
        param = request.getParameter("id");
        if (!(param == null || param.trim().isEmpty())) {
            fileId = Integer.valueOf(param);

            UploadFile file = dao.getByFileId(fileId);

            String fileUUID = file.getFileUUID();

            // gets absolute path of the web application
            String appPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String filePath = appPath + /*File.separator +*/ SAVE_DIR + File.separator + fileUUID;
            File downloadFile = new File(filePath);

            OutputStream outStream;

            // if you want to use a relative path to context root:
            try (FileInputStream inStream = new FileInputStream(downloadFile)) {
                // if you want to use a relative path to context root:
                String relativePath = getServletContext().getRealPath("");
                System.out.println("relativePath = " + relativePath);

                // obtains ServletContext
                ServletContext context = getServletContext();

                // gets MIME type of the file
                String mimeType = context.getMimeType(filePath);
                if (mimeType == null) {
                    // set to binary type if MIME mapping not found
                    mimeType = "application/octet-stream";
                }
                System.out.println("MIME type: " + mimeType);

                // modifies response
                response.setContentType(mimeType);
                response.setContentLength((int) downloadFile.length());

                // forces download
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", file.getFileName());
                response.setHeader(headerKey, headerValue);
                // obtains response's output stream
                outStream = response.getOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }
            outStream.close();
        }
    }
}
