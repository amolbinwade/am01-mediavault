// FileStatusResponse.java
package com.am01.mediavault.uploadservice.dto;

import com.am01.mediavault.uploadservice.model.FileUpload;

public class FileStatusResponse {
    private String status;
    private FileUpload fileMetadata;

    // getters and setters
    public FileStatusResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FileUpload getFileMetadata() {
        return fileMetadata;
    }

    public void setFileMetadata(FileUpload fileMetadata) {
        this.fileMetadata = fileMetadata;
    }
}