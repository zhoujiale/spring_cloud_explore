package com.zjl.spring_cloud_explore.spring_cloud_stock.error;

import com.zjl.commons.util.error.BusinessException;
import com.zjl.commons.util.response.WebResponse;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhou
 * @version 1.0
 * @className ErrorHandler
 * @description
 * @date 2022/02/07 17:36
 **/
@Aspect
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BusinessException.class)
    public WebResponse businessErrorHandler(BusinessException exception) {
        return WebResponse.fail(exception.getCode(), exception.getMessage());
    }
}
