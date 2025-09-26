package com.am01.mediavault.uploadservice.dto;

public class GenerateSignedUrlResponse {
    private String signedUrl;
    private String fileId;

    // getters and setters
    public GenerateSignedUrlResponse() {
    }

    public String getSignedUrl() {
        return signedUrl;
    }

    public void setSignedUrl(String signedUrl) {
        this.signedUrl = signedUrl;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}