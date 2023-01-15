package com.dddn.DDDnyang.controller;

import com.dddn.DDDnyang.constant.ApiConstant;
import com.dddn.DDDnyang.entity.Board;
import com.dddn.DDDnyang.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 게시글 REST 컨트롤러 클래스
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.BOARD)
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> listBoard(
            @RequestParam Map<String, Object> paramMap
    ) {
        List<Board> boardList = boardService.listBoard(paramMap);
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }
}
