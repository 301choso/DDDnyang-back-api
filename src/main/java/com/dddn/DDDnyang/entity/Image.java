package com.dddn.DDDnyang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

    private String image_sort;

    private String image_file_original_name;

    private String image_file_name;

    private LocalDateTime image_date;

    private Long board_id;

    private Long member_num;

    @JsonIgnore
    public String getRefKey() {
        return String.valueOf(this.image_id);
    }

}
