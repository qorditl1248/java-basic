package com.study.board.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 전역에서 rest 컨트롤러에 대한 예외 잡아줌
public class GlobalExceptionHandler {

    // body에는 오류에 대한 메세지가 들어감

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(DuplicateIsbnException.class)
    public ResponseEntity<ErrorResponse> handleException(DuplicateIsbnException e) {
        return ResponseEntity.status(ErrorCode.INVALD_INPUT_VALUE.getStatus())
                .body(new ErrorResponse(e.getMessage()));
    }

}
