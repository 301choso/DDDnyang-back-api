package com.dddn.DDDnyang.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@SuperBuilder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_id;

    private String board_title;

    private String board_content;

    private LocalDateTime board_date;

    private Long board_views;

    private Long board_like_it;

    private String board_category;

    private Long member_num;

    private String show_yn;

}
