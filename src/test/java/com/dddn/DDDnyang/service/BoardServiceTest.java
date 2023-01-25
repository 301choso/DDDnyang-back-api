package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Board;
import com.dddn.DDDnyang.repository.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardServiceTest {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Test
    public void 제목확인() {
        List<Board> bList = boardRepository.findAll();
        assertEquals("제목", bList.get(0).getBoard_title());
    }

    @Test
    public void 입력확인() {
        Board board = new Board();
        board.setBoard_id(124L);
        board.setBoard_title("제목123");
        board.setBoard_content("내용");
        board.setBoard_date(LocalDateTime.now());
        board.setBoard_views(0L);
        board.setBoard_like_it(0L);
        board.setBoard_category("공지");
        board.setMember_num(1L);
        board.setShow_yn("Y");
        Board save = boardRepository.save(board);
        assertEquals(save.getBoard_title(), "제목123");
    }

}