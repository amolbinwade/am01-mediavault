package com.am01.mediavault.uploadservice.dto;

public class NotifyUploadResponse {
    private String status; // PENDING_SCAN

    // getters and setters
    public NotifyUploadResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}