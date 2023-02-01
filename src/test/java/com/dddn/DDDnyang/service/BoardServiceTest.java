package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Board;
import com.dddn.DDDnyang.repository.BoardRepository;
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
        assertEquals("제목", bList.get(0).getBoardTitle());
    }

    @Test
    public void 입력확인() {
        Board board = new Board();
        board.setBoardId(124L);
        board.setBoardTitle("제목123");
        board.setBoardContent("내용");
        board.setBoardDate(LocalDateTime.now());
        board.setBoardViews(0L);
        board.setBoardLikeIt(0L);
        board.setBoardCategory("공지");
        board.setMemberNum(1L);
        board.setShowYn("Y");
        Board save = boardRepository.save(board);
        assertEquals(save.getBoardTitle(), "제목123");
    }

}