package com.dddn.DDDnyang.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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
    private String boardTitle;
    private String boardContent;
    private Date boardDate;
    private int boardViews;
    private int boardLikeIt;
    private String boardCategory;
    private int memberNum;
    private String fileInfo;
    private String showYn;

}
