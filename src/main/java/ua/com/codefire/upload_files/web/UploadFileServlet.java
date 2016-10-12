/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.upload_files.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static java.util.UUID.randomUUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.com.codefire.upload_files.dao.IUploadFileDao;
import ua.com.codefire.upload_files.dao.UploadFileDaoImpl;
import ua.com.codefire.upload_files.dao.models.UploadFile;
import ua.com.codefire.upload_files.files.Utils;

/**
 * http://www.codejava.net/java-ee/servlet/java-file-upload-example-with-servlet-30-api
 *
 * @author Igor Gayvan
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadFileServlet extends HttpServlet {

    /**
     * Name of the directory where uploaded files will be saved, relative to the
     * web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";

    private final IUploadFileDao dao = new UploadFileDaoImpl();

    /**
     * Show upload form
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param;
        param = request.getParameter("id");
        if (param == null || param.trim().isEmpty()) {
            getServletContext().getRequestDispatcher("/WEB-INF/views/upload_file.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/DownloadFileServlet").forward(request, response);
        }
    }

    /**
     * Handles file upload
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + /*File.separator +*/ SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        List<UploadFile> listUploadFile = new ArrayList<>();

        String fileUUID = randomUUID().toString();
        for (Part part : request.getParts()) {
            String fileName = fileName = extractFileName(part);
            part.write(savePath + File.separator + fileUUID);

            UploadFile uploadFile = new UploadFile();
            uploadFile.setFileName(fileName);
            uploadFile.setFilePath(savePath);
            uploadFile.setFileUUID(fileUUID);
            try {
                uploadFile.setFileMd5(Utils.getDigest(new FileInputStream(new File(savePath + File.separator + fileUUID))));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UploadFileServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            dao.add(uploadFile);

            listUploadFile.add(uploadFile);
        }

        request.setAttribute("message", "Upload has been done successfully!");
        request.setAttribute("listUploadFile", listUploadFile);
        getServletContext().getRequestDispatcher("/WEB-INF/views/upload_result.jsp").forward(request, response);
    }

    /**
     * Extracts file name from HTTP header content-disposition
     *
     * @param part
     * @return
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
