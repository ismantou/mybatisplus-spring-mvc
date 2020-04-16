package com.model.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.model.SuperEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@TableName("t_student")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student extends SuperEntity {

    @TableField(value = "class_id")
    private Integer classId;

    private String className;

    @TableField(condition = SqlCondition.LIKE)
    private String name;

    private String age;

    private String gender;

}
