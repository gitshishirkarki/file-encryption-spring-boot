
# File Encryption and Decryption with Spring Boot

This project demonstrates how to implement **file encryption** and **decryption** in a Spring Boot application using AES (Advanced Encryption Standard). The project allows users to upload a file, which gets encrypted and stored. When requested, the file is decrypted and returned.

## Features

- **File Upload**: Upload files through the API.
- **AES Encryption**: Securely encrypt files using AES.
- **Decryption**: Decrypt the stored files and return them to the user.

## Prerequisites

To run this project, you will need:

- **JDK 17** or later
- **Gradle**
- **Spring Boot 3.x**

## Getting Started

### Clone the repository

```bash
git clone https://github.com/gitshishirkarki/file-encryption-spring-boot.git
```

### Build the Project

Navigate to the project directory and build the project using Gradle:

```bash
./gradlew build
```

### Run the Application

You can run the application locally using:

```bash
./gradlew bootRun
```

The app will start on `localhost:8080`.

## API Endpoints

### 1. Upload and Encrypt a File

```http
POST /api/files/upload
```

- **Request**: Multipart file upload via `form-data`.
- **Response**: Path to the encrypted file.

### 2. Download and Decrypt a File

```http
GET /api/files/download?fileName={fileName}
```

- **Request**: File name of the encrypted file (without `.enc` extension).
- **Response**: Path to the decrypted file.

## AES Encryption Details

The encryption and decryption are handled using AES (Advanced Encryption Standard). The key used in this demo is a 128-bit key defined in the `FileService.java` class. For production use, ensure to use a stronger key and manage keys securely.

## Project Structure

- **`AESUtil.java`**: Utility class that handles AES encryption and decryption.
- **`FileService.java`**: Service class that manages file upload, encryption, and decryption.
- **`FileController.java`**: REST controller that exposes endpoints for file operations.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use it for educational purposes.