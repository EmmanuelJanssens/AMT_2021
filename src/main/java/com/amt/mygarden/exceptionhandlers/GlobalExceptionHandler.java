package com.amt.mygarden.exceptionhandlers;

import com.amt.mygarden.exceptions.FruitNotFoundException;
import com.amt.mygarden.exceptions.PageNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger;

    GlobalExceptionHandler(){
        logger = LoggerFactory.getLogger(getClass());
    }

}
