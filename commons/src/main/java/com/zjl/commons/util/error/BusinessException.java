package com.zjl.commons.util.error;

import com.zjl.commons.util.constant.ResultCode;
import lombok.Getter;

/**
 * @author zhou
 * @version 1.0
 * @className BusinessException
 * @description
 * @date 2022/02/07 17:29
 **/
@Getter
public class BusinessException extends RuntimeException{

    private String code;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    public BusinessException(String code,String msg){
        super(msg);
        this.code = code;
    }
}
