package com.dddn.DDDnyang.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;

    private String memberId;

    private String memberEmail;

    private String memberCall;

    private String memberName;

    private String memberYn;

    private String memberPw;

    private LocalDateTime memberJoinDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Session> sessions = new ArrayList<>();

    public Session addSession() {
        Session session = Session.builder()
                .member(this)
                .build();
        sessions.add(session);
        return session;
    }
}
