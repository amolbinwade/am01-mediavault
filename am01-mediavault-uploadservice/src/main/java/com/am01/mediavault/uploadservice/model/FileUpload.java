package com.am01.mediavault.uploadservice.model;

import java.time.Instant;

public class FileUpload {
    private String id;
    private String fileName;
    private String contentType;
    private Instant uploadTime;
    private String scanStatus; // PENDING_SCAN, CLEAN, INFECTED
    // getters and setters
    public FileUpload() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public Instant getUploadTime() {
        return uploadTime;
    }
    public void setUploadTime(Instant uploadTime) {
        this.uploadTime = uploadTime;
    }
    public String getScanStatus() {
        return scanStatus;
    }
    public void setScanStatus(String scanStatus) {
        this.scanStatus = scanStatus;
    }
}