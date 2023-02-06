package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Board;
import com.dddn.DDDnyang.repository.BoardRepository;
import com.dddn.DDDnyang.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> listBoard(Map<String, Object> paramMap) {
        return boardRepository.findAll();
    }

    public Board saveBoard(BoardVO boardVO) {
        return boardRepository.save(Board.builder()
                .boardTitle(boardVO.getBoardTitle())
                .boardContent(boardVO.getBoardContent())
                .boardDate(LocalDateTime.now())
                .boardCategory(boardVO.getBoardCategory())
                .boardViews(0L)
                .boardLikeIt(0L)
                .memberNum(boardVO.getMemberNum())
                .showYn(boardVO.getShowYn())
                .build());
    }

}
