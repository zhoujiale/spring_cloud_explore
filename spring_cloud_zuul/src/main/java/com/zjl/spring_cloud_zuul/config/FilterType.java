package com.zjl.spring_cloud_zuul.config;

import lombok.Getter;

/**
 * @author zhou
 * @className FilterType
 * @description
 * @date 2021/07/05 12/41
 **/
@Getter
public enum FilterType {

    PRE("pre"),
    ROUTING("routing"),
    ERROR("error"),
    POST("post")
    ;
    private String type;

    FilterType(String type) {
        this.type = type;
    }
}
