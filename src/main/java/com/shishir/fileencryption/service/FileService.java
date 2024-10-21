package com.shishir.fileencryption.service;

import com.shishir.fileencryption.utils.AESUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private final String directory = "E:\\PERSONAL\\file-encryption-spring-boot\\encryptedfiles\\";
    private final String encryptionKey = "mysecretkey12345"; // 128 bit key for AES

    public String encryptAndSaveFile(MultipartFile file) throws Exception {
        // Create a directory to save files
        Files.createDirectories(Paths.get(directory));

        // Encrypt the file and save
        byte[] encryptedData = AESUtil.encrypt(file.getBytes(), encryptionKey);
        String filePath = directory + file.getOriginalFilename() + ".enc";
        Files.write(Paths.get(filePath), encryptedData);

        return filePath;
    }

    public Path decryptAndRetrieveFile(String fileName) throws Exception {
        Path encryptedFilePath = Paths.get(directory + fileName + ".enc");

        // Decrypt the file
        byte[] decryptedData = AESUtil.decrypt(Files.readAllBytes(encryptedFilePath), encryptionKey);
        Path decryptedFilePath = Paths.get(directory + "decrypted_" + fileName);

        // Save decrypted file
        Files.write(decryptedFilePath, decryptedData);
        return decryptedFilePath;
    }
}
