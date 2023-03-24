package com.hit.base_1.config.exception;


import com.hit.base_1.adapter.web.base.ResponseUtil;
import com.hit.base_1.adapter.web.base.RestData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class ExceptionHandlerConfig {
    private static final Log LOG = LogFactory.getLog(ExceptionHandlerConfig.class);

    private final MessageSource messageSource;

    public ExceptionHandlerConfig(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<RestData<?>> handleNotFoundException(NotFoundException ex) {
        LOG.error(ex.getMessage(), ex);
        String message = ex.getMessage();
        List<String> messages = new ArrayList<>();
        messages.add(message);
        return ResponseUtil.error(HttpStatus.NOT_FOUND,messages);
    }
    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<RestData<?>> handleBadRequestException(BadRequestException ex) {
        List<String> messages = new ArrayList<>();
        LOG.error(ex.getMessage(), ex);
        String message = ex.getMessage();
        messages.add(message);
        return ResponseUtil.error(HttpStatus.BAD_REQUEST,messages);
    }
    @ExceptionHandler(value = {BindException.class})
    protected ResponseEntity<RestData<?>> handleBindException(BindException ex) {
        LOG.error(ex.getMessage(), ex);

        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            try {
                errors.add(fieldError.getField()+" "+fieldError.getDefaultMessage());
            } catch (Exception e) {
                errors.add(messageSource.getMessage("exception.general", null, LocaleContextHolder.getLocale()));
            }
        }
        return ResponseUtil.error(HttpStatus.BAD_REQUEST, errors);
    }
}
