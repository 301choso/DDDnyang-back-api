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
    private int board_id;
    private String board_title;
    private String board_content;
    private Date board_date;
    private int board_views;
    private int board_like_it;
    private String board_category;
    private int member_num;
    private String fileInfo;
    private String show_yn;

}
