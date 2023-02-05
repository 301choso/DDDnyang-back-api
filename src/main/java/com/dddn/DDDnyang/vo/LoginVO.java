package com.dddn.DDDnyang.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Builder
public class LoginVO {

    private String memberId;
    private String memberPw;

    @Builder
    public LoginVO(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }
}
