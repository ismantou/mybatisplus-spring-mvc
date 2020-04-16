package com.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.common.result.Result;
import com.common.utils.JsonUtil;


import com.common.utils.model.Pager;
import com.model.enums.ResultEnum;
import com.model.system.MyClass;
import com.model.system.Student;
import com.model.vo.ClassVo;
import com.service.system.IMyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;


/**
 * @author huang
 */
@RestController
public class ClassController {
    @Autowired
    private IMyClassService classService;


    @GetMapping("classPage")
    public Result<Object> getClasss(@RequestParam(required = false,defaultValue = "1") String page,@RequestParam(required = false,defaultValue = "2") String size){

        if (page != "" && size !="") {
            Page<Map<String,Object>> cPage =new Page<>(Integer.valueOf(page),Integer.valueOf(size));
            Page<Map<String,Object>> myPage = classService.selectClassPage(cPage);
            Map<String,Object> returnMap = new HashMap<>(8);
            returnMap.put("classList",cPage.getRecords());
            returnMap.put("page",cPage.getPages());
            returnMap.put("size",cPage.getSize());
            returnMap.put("total",cPage.getTotal());
            return new Result(returnMap);
        }else {
            return new Result("非法~~");
        }
    }

    @RequestMapping(value = "/getClass",method = RequestMethod.GET)
    public Result<Object> getC(String gridPager){
        Pager pager = JsonUtil.getObjectFromJson(gridPager, Pager.class);
        Map<String, Object> parameters = null;
//        if(Validator.isNullOrEmpty(pager.getParameters())){
//            parameters = new HashMap<>();
//            parameters.put("pid", 0);
//        }else{
//            parameters = pager.getParameters();
//            if(Validator.isNullOrEmpty(parameters.get("pid"))){
//                parameters.put("pid", 0);
//            }
//        }
        Page<Map<String,Object>> list = classService.selectClass(new Page<Map<String,Object>>(pager.getNowPage(), pager.getPageSize()), Condition.create().allEq(parameters));
        return null;
    }

}
