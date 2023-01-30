package com.dddn.DDDnyang.controller;

import com.dddn.DDDnyang.constant.ApiConstant;
import com.dddn.DDDnyang.entity.Image;
import com.dddn.DDDnyang.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 이미지 REST 컨트롤러 클래스
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.IMAGE)
public class ImageController {

    private final ImageService imageService;

    @GetMapping()
    public ResponseEntity<List<Image>> listImage(@RequestParam Map<String, Object> paramMap) {
        List<Image> imageList = imageService.listImage(paramMap);
        return ResponseEntity.status(HttpStatus.OK).body(imageList);
    }

    @PostMapping()
    public ResponseEntity insertImage(@RequestParam Image image, @RequestParam("file")MultipartFile file) {
        imageService.uploadImage(image, file);
        return ResponseEntity.status(HttpStatus.OK).body(image);
    }

}
