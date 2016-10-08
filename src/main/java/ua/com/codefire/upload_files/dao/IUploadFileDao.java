/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.upload_files.dao;

import ua.com.codefire.upload_files.dao.models.UploadFile;

/**
 *
 * @author Igor Gayvan
 */
public interface IUploadFileDao {

    UploadFile getByFileUUID(String fileUUID);

    void add(UploadFile uploadFile);
}
