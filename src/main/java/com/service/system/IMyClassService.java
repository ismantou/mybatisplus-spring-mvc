package com.service.system;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.model.system.MyClass;
import com.model.vo.ClassVo;


import java.util.Map;

/**
 * @author huang
 */
public interface IMyClassService extends IService<MyClass> {


    /**
     * 自定义分页查询
     * @param page
     * @param wrapper
     * @return
     */
    Page<Map<String, Object>> selectClass(Page<Map<String, Object>> page, Wrapper<MyClass> wrapper);

    Page<Map<String,Object>> selectClassPage(Page<Map<String,Object>> cPage);
}
