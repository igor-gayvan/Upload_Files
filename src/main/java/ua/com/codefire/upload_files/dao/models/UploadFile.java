/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.upload_files.dao.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Igor Gayvan
 */
@Entity
@Table(name = "upload_files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadFile.findAll", query = "SELECT u FROM UploadFile u"),
    @NamedQuery(name = "UploadFile.findByFileId", query = "SELECT u FROM UploadFile u WHERE u.fileId = :fileId"),
    @NamedQuery(name = "UploadFile.findByFileName", query = "SELECT u FROM UploadFile u WHERE u.fileName = :fileName"),
    @NamedQuery(name = "UploadFile.findByFilePath", query = "SELECT u FROM UploadFile u WHERE u.filePath = :filePath"),
    @NamedQuery(name = "UploadFile.findByFileUUID", query = "SELECT u FROM UploadFile u WHERE u.fileUUID = :fileUUID"),
    @NamedQuery(name = "UploadFile.findByFileMd5", query = "SELECT u FROM UploadFile u WHERE u.fileMd5 = :fileMd5"),
    @NamedQuery(name = "UploadFile.findByDateRec", query = "SELECT u FROM UploadFile u WHERE u.dateRec = :dateRec")})
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "file_id")
    private Integer fileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "file_path")
    private String filePath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "file_UUID")
    private String fileUUID;
    @Size(max = 32)
    @Column(name = "file_md5")
    private String fileMd5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_rec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRec;

    public UploadFile() {
    }

    public UploadFile(Integer fileId, String fileName, String filePath, String fileUUID) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileUUID = fileUUID;
    }

    public Integer getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileUUID() {
        return fileUUID;
    }

    public void setFileUUID(String fileUUID) {
        this.fileUUID = fileUUID;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public Date getDateRec() {
        return dateRec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileId != null ? fileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UploadFile other = (UploadFile) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        if (!Objects.equals(this.fileUUID, other.fileUUID)) {
            return false;
        }
        if (!Objects.equals(this.fileMd5, other.fileMd5)) {
            return false;
        }
        if (!Objects.equals(this.fileId, other.fileId)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "UploadFile{" + "fileId=" + fileId + ", fileName=" + fileName + ", filePath=" + filePath + ", fileUUID=" + fileUUID + ", fileMd5=" + fileMd5 + ", dateRec=" + dateRec + '}';
    }

}
