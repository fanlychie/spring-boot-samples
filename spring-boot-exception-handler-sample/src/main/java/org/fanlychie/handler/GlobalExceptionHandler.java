package org.fanlychie.handler;

import org.fanlychie.exception.BusinessHtmlException;
import org.fanlychie.exception.BusinessJsonException;
import org.fanlychie.exception.IllegalArgumentJsonException;
import org.fanlychie.http.HttpResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fanlychie on 2017/6/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessHtmlException.class)
    public ModelAndView handleHtmlException(Throwable e) {
        logger.error("「捕捉到异常」：", e);
        ModelAndView modelAndView = new ModelAndView("error/general");
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler({
            BusinessJsonException.class,
            IllegalArgumentJsonException.class
    })
    public ResponseEntity<?> handleJsonException(Exception e) {
        logger.error("「捕捉到异常」：", e);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new HttpResponseBody(status.value(), e.getMessage(), null), status);
    }

}