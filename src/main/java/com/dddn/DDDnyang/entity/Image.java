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
    private Long imageId;

    private String imageSort;

    private String imageFileOriginalName;

    private String imageFileName;

    private LocalDateTime imageDate;

    private Long boardId;

    private Long memberNum;

    @JsonIgnore
    public String getRefKey() {
        return String.valueOf(this.imageId);
    }

}
