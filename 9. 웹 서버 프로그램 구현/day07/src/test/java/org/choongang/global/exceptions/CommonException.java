package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;
//어떤 상태냐에
public class CommonException extends RuntimeException {
    private int status; //응답코드

    public CommonException(String message) {
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    public CommonException(String message, int status) {
        super(message);
        this.status =status;
    }
    public int getStatus() {
        return status; //위 응답코드 조회
    }

}
