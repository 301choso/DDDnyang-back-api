package com.dddn.DDDnyang.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MinioService {

    @Value("${spring.minio.bucket}")
    private String bucket;

    private final MinioClient minioClient;

    public boolean fileUpload(String path, MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                        .bucket(bucket)
                        .object(path)
                        .stream(inputStream, file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());
            return true;
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException e) {
            log.error(e.getMessage(), e);
            return false;
        } catch (io.minio.errors.ServerException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream fileDownload(String path) {
        try {
            return minioClient.getObject(
                GetObjectArgs.builder()
                            .bucket(bucket)
                            .object(path)
                            .offset(1024L)
                            .build());
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException e) {
            log.error(e.getMessage(), e);
            return null;
        } catch (io.minio.errors.ServerException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean fileRemove(String path) {
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                                    .bucket(bucket)
                                    .object(path)
                                    .build()
            );
            return true;
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException | XmlParserException e) {
            return false;
        }
    }

}
