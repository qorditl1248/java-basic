package com.study.board.global.exception;

public enum ErrorCode {
    ENTITY_NOT_FOUND(404, "C001", "Entity Not Found"),
    INVALD_INPUT_VALUE(400, "C003", "Invalid Input Value"),
    INVALD_TYPE_VALUE(400, "C005", "Entity Not Found"),
    METHOD_NOT_ALLOWED(405, "C003", "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    HADEL_ACCESS_DENIED(403, "C006", "Access");

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    private final String code;
    private final String message;
    private final int status;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
