package com.model.system;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.model.SuperEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.model.enums.TypeEnum;
import lombok.Data;

/**
 * 系统用户表
 */
@TableName("sys_user")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class User extends SuperEntity {

    /**
     * 用户名
     * 这样可以注入 LIKE 查询
     */
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    /**
     * 通用枚举测试
     */
    private TypeEnum type;
    /**
     * 用户年龄
     */
    private Integer age;
    /**
     * 自定义填充的创建时间
     */
    @TableField(fill = FieldFill.INSERT) // 这样可以注入更新数据库时间 , update = "now()")// 该注解插入忽略验证，自动填充
    private Date ctime;

}
