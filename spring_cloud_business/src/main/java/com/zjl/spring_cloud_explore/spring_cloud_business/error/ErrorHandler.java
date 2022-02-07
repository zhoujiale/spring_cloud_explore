package com.zjl.spring_cloud_explore.spring_cloud_business.error;

import com.zjl.commons.util.error.BusinessException;
import com.zjl.commons.util.response.WebResponse;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zhou
 * @version 1.0
 * @className ErrorHandler
 * @description
 * @date 2022/02/07 17:36
 **/
@Aspect
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BusinessException.class)
    public WebResponse businessErrorHandler(BusinessException exception) {
        return WebResponse.fail(exception.getCode(), exception.getMessage());
    }
}
