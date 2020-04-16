package com.service.system.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mapper.system.ClassMapper;
import com.model.system.MyClass;
import com.model.vo.ClassVo;
import com.service.system.IMyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author huang
 */
@Service
public class MyClassServiceImpl extends ServiceImpl<ClassMapper, MyClass> implements IMyClassService {

    @Autowired
    private ClassMapper classMapper;



    @Override
    public Page<Map<String, Object>> selectClass(Page<Map<String, Object>> page, Wrapper<MyClass> wrapper) {
        page.setRecords(classMapper.selectClassList(page,wrapper));
        return page;
    }

    @Override
    public Page<Map<String,Object>> selectClassPage(Page<Map<String,Object>> page) {
        page.setRecords(classMapper.getClassList(page));
        return page;
    }
}
