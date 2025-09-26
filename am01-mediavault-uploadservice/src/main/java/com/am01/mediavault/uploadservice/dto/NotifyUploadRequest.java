package com.am01.mediavault.uploadservice.dto;

public class NotifyUploadRequest {
    private String fileId;

    // getters and setters
    public NotifyUploadRequest() {
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}