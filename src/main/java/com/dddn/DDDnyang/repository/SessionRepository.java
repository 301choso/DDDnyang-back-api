package com.dddn.DDDnyang.repository;

import com.dddn.DDDnyang.entity.Session;
import org.springframework.data.repository.CrudRepository;

/**
 * 세션 Repository 인터페이스
 */

public interface SessionRepository extends CrudRepository<Session, Long> {

}
