package com.am01.mediavault.uploadservice.service.impl;

import com.am01.mediavault.uploadservice.dto.*;
import com.am01.mediavault.uploadservice.model.FileUpload;
import com.am01.mediavault.uploadservice.service.FileUploadService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    // In-memory store for demo; replace with repository in production
    private final Map<String, FileUpload> fileStore = new HashMap<>();

    @Override
    public GenerateSignedUrlResponse generateSignedUrl(GenerateSignedUrlRequest request) {
        String fileId = UUID.randomUUID().toString();
        String signedUrl = "https://storage.googleapis.com/bucket/" + request.getFileName() + "?signed"; // placeholder

        FileUpload fileUpload = new FileUpload();
        fileUpload.setId(fileId);
        fileUpload.setFileName(request.getFileName());
        fileUpload.setContentType(request.getContentType());
        fileUpload.setUploadTime(Instant.now());
        fileUpload.setScanStatus("PENDING_SCAN");
        fileStore.put(fileId, fileUpload);

        GenerateSignedUrlResponse response = new GenerateSignedUrlResponse();
        response.setSignedUrl(signedUrl);
        response.setFileId(fileId);
        return response;
    }

    @Override
    public NotifyUploadResponse notifyUpload(NotifyUploadRequest request) {
        FileUpload fileUpload = fileStore.get(request.getFileId());
        if (fileUpload != null) {
            fileUpload.setScanStatus("PENDING_SCAN");
        }
        NotifyUploadResponse response = new NotifyUploadResponse();
        response.setStatus("PENDING_SCAN");
        return response;
    }

    @Override
    public FileStatusResponse getFileStatus(String fileId) {
        FileUpload fileUpload = fileStore.get(fileId);
        FileStatusResponse response = new FileStatusResponse();
        if (fileUpload != null) {
            response.setStatus(fileUpload.getScanStatus());
            response.setFileMetadata(fileUpload);
        }
        return response;
    }
}