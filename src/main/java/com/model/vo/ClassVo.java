package com.model.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.model.SuperEntity;
import com.model.system.Student;
import lombok.Data;

import java.util.List;

@Data
public class ClassVo extends SuperEntity {

    private Integer classId;
    private String className;
    @TableField(exist = false)
    private List<Student> students;
}
