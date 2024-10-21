package com.shishir.fileencryption.controller;

import com.shishir.fileencryption.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String encryptedFilePath = fileService.encryptAndSaveFile(file);
            return "File uploaded and encrypted successfully: " + encryptedFilePath;
        } catch (Exception e) {
            return "File upload failed: " + e.getMessage();
        }
    }

    @GetMapping("/download")
    public String downloadFile(@RequestParam String fileName) {
        try {
            Path decryptedFilePath = fileService.decryptAndRetrieveFile(fileName);
            return "File decrypted successfully: " + decryptedFilePath;
        } catch (Exception e) {
            return "File download failed: " + e.getMessage();
        }
    }
}
