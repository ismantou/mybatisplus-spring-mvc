package com.model.enums;


import lombok.Getter;

/**
 * 返回结果枚举
 * @author huang
 */
@Getter
public enum ResultEnum {
    /**
     * 返回结果枚举，每个枚举代表着一个返回状态
     */
    SUCCESS(20000, "操作成功！"),
    DATA_NULL(20001,"暂无数据"),
    ERROR(40000, "操作失败！"),
    DATA_NOT_FOUND(40001, "查询失败！"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
