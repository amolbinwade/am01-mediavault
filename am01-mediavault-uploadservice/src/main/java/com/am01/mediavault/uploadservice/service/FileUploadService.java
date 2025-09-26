package com.am01.mediavault.uploadservice.service;

import com.am01.mediavault.uploadservice.dto.*;

public interface FileUploadService {
    GenerateSignedUrlResponse generateSignedUrl(GenerateSignedUrlRequest request);
    NotifyUploadResponse notifyUpload(NotifyUploadRequest request);
    FileStatusResponse getFileStatus(String fileId);
}