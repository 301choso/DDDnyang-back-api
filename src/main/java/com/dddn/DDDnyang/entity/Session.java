package com.dddn.DDDnyang.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    private String accessToken;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NUM")
    private Member member;

    @Builder
    public Session(Member member) {
        this.accessToken = UUID.randomUUID().toString();
        this.member = member;
    }
}
