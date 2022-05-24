package com.oliveira.pages.exceptionhandling;

import com.oliveira.pages.exception.PageNotFoundException;
import com.oliveira.pages.util.GsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class PageExceptionHandling extends ResponseEntityExceptionHandler {

    private static final Logger logger = LogManager.getLogger(PageExceptionHandling.class);

    private final MessageSource messageSource;

    @Autowired
    public PageExceptionHandling(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse(
                "Server Error",
                "server.error"   ,
                details);

        logger.error("Server Error" + GsonUtil.build().toJson(error));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse(
                "Server Error",
                "server.error",
                details);

        logger.error("Server Error" + GsonUtil.build().toJson(error));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundError(Exception ex) {
        List<String> details = new ArrayList<>();

        details.add(this.getMessage(ex.getMessage()));

        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                this.getMessage(ex.getMessage()),
                details);

        logger.error("Page not found" + GsonUtil.build().toJson(error));

        return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> details = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        ErrorResponse error = new ErrorResponse(
                "Validation Failed",
                "validation.failed",
                details);

        logger.error("Validation Failed" + GsonUtil.build().toJson(error));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.CANADA);
    }
}
