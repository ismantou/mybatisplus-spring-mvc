package com.service.system;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.model.system.Student;


public interface IStudentService extends IService<Student> {

    Page<Student> selectStuPage(Page<Student> page,String s,String c);

}
