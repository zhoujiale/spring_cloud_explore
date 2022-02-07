package com.zjl.commons.util.constant;

import lombok.Getter;

/**
 * @author zhou
 * @className ResultCode
 * @description
 * @date 2022/02/07 17/19
 **/
@Getter
public enum ResultCode {

    SUCCESS("200","成功"),
    STOCK_EMPTY("5001","查询不到商品")
    ;

    private String code;

    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
