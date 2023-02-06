package com.dddn.DDDnyang.repository;

import com.dddn.DDDnyang.entity.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * 세션 Repository 인터페이스
 */

public interface SessionRepository extends CrudRepository<Session, Long> {

    Optional<Session> findByAccessToken(String accessToken);
}
