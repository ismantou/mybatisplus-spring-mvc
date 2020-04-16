package com.model.enums;

import lombok.Getter;

/**
 * 状态码枚举
 *
 * @author huang
 */
@Getter
public enum StateEnums {

    /**
     * 请求访问状态枚举
     */
    REQUEST_SUCCESS(1, "请求正常"),
    REQUEST_ERROR(0, "请求异常");


    private Integer code;
    private String msg;

    StateEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
