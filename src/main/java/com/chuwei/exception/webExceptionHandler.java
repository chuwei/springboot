package com.chuwei.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by win on 2019/8/20.
 */
@ControllerAdvice
public class webExceptionHandler {
    public static final String  ERROR_VIEW = "error";

    @ExceptionHandler(value =Exception.class)
    public ModelAndView errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws  Exception {
        e.printStackTrace();
        ModelAndView mav= new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return  mav;
    }

}
