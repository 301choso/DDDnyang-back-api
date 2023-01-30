package com.dddn.DDDnyang.repository;

import com.dddn.DDDnyang.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 이미지 Repository 인터페이스
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
