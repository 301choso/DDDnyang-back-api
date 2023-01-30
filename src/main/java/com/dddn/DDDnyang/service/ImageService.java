package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Image;
import com.dddn.DDDnyang.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    private final MinioService minioService;

    public List<Image> listImage(Map<String, Object> paramMap) {
        return imageRepository.findAll();
    }

    /**
     * 이미지 업로드
     */
    public UUID uploadImage(Image image, MultipartFile file) {
        if(file == null || file.isEmpty() || file.getSize() < 1) {
            throw  new RuntimeException("잘못된 파일입니다.");
        }

        /*String mimeType = file.getContentType(); // 미디어타입
        String displayName = file.getOriginalFilename();
        long fileSize = file.getSize();*/
        String type = image.getImage_sort();
        UUID uploadId = UUID.randomUUID();
        LocalDateTime regDt = LocalDateTime.now();
        String savePath = "";
        if (uploadId == null) {
            throw new RuntimeException("첨부파일 아이디가 올바르지 않습니다.");
        } else {
           // 유효성 확인
           if(type == null) {
               throw new RuntimeException("첨부파일 유형이 올바르지 않습니다.");
           }
           if (regDt == null) {
               throw new RuntimeException("첨부파일 등록일자가 없습니다.");
           }
           String yearMonth = regDt.format(DateTimeFormatter.ofPattern("yyyyMM"));
           savePath = type + "/" + yearMonth;

            boolean isSuccessUpdate = minioService.fileUpload(savePath, file);
            if(!isSuccessUpdate) {
                throw new RuntimeException("첨부파일 저장에 실패했습니다.");
            } else {
                imageRepository.save(image);
            }
        }
        return uploadId;
    }

}
