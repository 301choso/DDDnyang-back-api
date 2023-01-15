package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Board;
import com.dddn.DDDnyang.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardServiceTest {
    @Autowired
    private BoardRepository boardRepository;

    /*@BeforeEach
    private void before() {
        Date date = new Date(2022-12-12);
        BoardVO boardVO = new BoardVO(1, "제목", "내용", date,0, 0, "공지사항", 1, "", "Y" );

    }*/

    @Test
    public void 제목확인() {
        List<Board> bList = boardRepository.findAll();

        assertEquals("제목", bList.get(0).getBoard_title());
    }

}