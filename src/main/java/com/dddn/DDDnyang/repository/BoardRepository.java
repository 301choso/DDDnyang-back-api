package com.dddn.DDDnyang.repository;

import com.dddn.DDDnyang.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 게시글 Repository 인터페이스
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

   List<Board> findAll();
}
