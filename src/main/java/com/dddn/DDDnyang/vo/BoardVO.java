package com.dddn.DDDnyang.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 게시글 VO
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {

    private int boardId;

    @NotBlank(message = "제목을 입력해주세요.")
    private String boardTitle;

    @NotBlank(message = "내용을 입력해주세요.")
    private String boardContent;

    private LocalDateTime boardDate;

    private int boardViews;

    private int boardLikeIt;

    private String boardCategory;

    private Long memberNum;

    private String fileInfo;

    private String showYn;

}
