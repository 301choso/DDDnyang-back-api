package com.dddn.DDDnyang.exception;

public class Unauthorized extends RuntimeException {

    private static final String Message = "인증이 필요합니다.";

    public Unauthorized() {
        super(Message);
    }

    public int getStatusCode() {
        return 404;
    }
}
