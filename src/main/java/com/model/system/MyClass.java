package com.model.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.model.SuperEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


/**
 * @author huang
 */
@TableName("t_class")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyClass extends SuperEntity {

    @TableField(value = "class_num")
    private String classNum;

    @TableField(value = "class_name")
    private String className;

}
