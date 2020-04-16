package com.service.system.impl;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mapper.system.StudentMapper;
import com.model.system.Student;
import com.service.system.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huang
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Page<Student> selectStuPage(Page<Student> page,String s,String n) {
        page.setRecords(studentMapper.selectMyPage(page,s,n));
        return page;
    }
}
