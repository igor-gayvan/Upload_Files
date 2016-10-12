/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.upload_files.dao;

import ua.com.codefire.upload_files.dao.models.UploadFile;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Igor Gayvan
 */
public class UploadFileDaoImpl implements IUploadFileDao {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Upload_Files");

    private EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public UploadFile getByFileUUID(String fileUUID) {
        EntityManager em = getEntityManager();
        UploadFile uploadFile = em.createNamedQuery("UploadFile.findByFileUUID", UploadFile.class).setParameter("fileUUID", fileUUID).getSingleResult();
        em.close();
        return uploadFile;
    }

    @Override
    public UploadFile getByFileId(int fileId) {
        EntityManager em = getEntityManager();
        UploadFile uploadFile = em.createNamedQuery("UploadFile.findByFileId", UploadFile.class).setParameter("fileId", fileId).getSingleResult();
        em.close();
        return uploadFile;
    }

    @Override
    public void add(UploadFile uploadFile) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(uploadFile);
        em.getTransaction().commit();
        em.close();
    }
}
