package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Image;
import com.dddn.DDDnyang.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public List<Image> listImage(Map<String, Object> paramMap) {
        return imageRepository.findAll();
    }

    public Image saveBoard(Image image) {
        return imageRepository.save(image);
    }

}
