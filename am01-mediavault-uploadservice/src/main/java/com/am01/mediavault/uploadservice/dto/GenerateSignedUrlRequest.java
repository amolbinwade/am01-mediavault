package com.am01.mediavault.uploadservice.dto;

public class GenerateSignedUrlRequest {
    private String fileName;
    private String contentType;
    // getters and setters

    public GenerateSignedUrlRequest() {
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
}