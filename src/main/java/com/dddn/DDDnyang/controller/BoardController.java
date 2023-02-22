package com.dddn.DDDnyang.controller;

import com.dddn.DDDnyang.constant.ApiConstant;
import com.dddn.DDDnyang.entity.Board;
import com.dddn.DDDnyang.service.BoardService;
import com.dddn.DDDnyang.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoard(
            @PathVariable Long boardId
    ) {
        Optional<Board> board = boardService.getBoard(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(board.orElseThrow(() -> new RuntimeException("게시물이 존재하지 않습니다.")));
    }

    @PostMapping
    public ResponseEntity<Map<String, Boolean>> saveBoard(
            @RequestBody @Valid BoardVO boardVO
    ) {
        Boolean isSuccess = boardService.saveBoard(boardVO).getBoardId() > 0;
        return ResponseEntity.status(isSuccess == true? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(null);
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<Map<String, Boolean>> editBoard(
            @RequestBody @Valid Board board
    ) {
        Boolean isSuccess = boardService.editBoard(board).getBoardId() > 0;
        return ResponseEntity.status(isSuccess == true? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(null);
    }
}
