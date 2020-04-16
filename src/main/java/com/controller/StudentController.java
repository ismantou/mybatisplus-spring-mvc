package com.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.common.result.Result;
import com.model.SuperEntity;
import com.model.enums.ResultEnum;
import com.model.system.MyClass;
import com.model.system.Student;
import com.service.system.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/stu")
    public Result<Object> getStu(@RequestParam(required = false,defaultValue = "") String name,@RequestParam(required = false,defaultValue = "1")String page,@RequestParam(required = false,defaultValue = "3")String size){
        String str = name.replaceAll(" ","");
        if (str=="" && str.length()==0){
            return new Result("没查到此人");
        }
        else {
            Page<Student> list = studentService.selectPage(new Page<Student>(Integer.valueOf(page),Integer.valueOf(size)),new EntityWrapper<Student>()
                    .like("name",str));

            return new Result(list.getRecords());
        }
    }

    @GetMapping("Students")
    public Result<Object> getStudents(@RequestParam(required = false,defaultValue = "1")String page,
                                      @RequestParam(required = false,defaultValue = "3 ")String size,
                                      @RequestParam(required = false,defaultValue = "")String name,
                                      @RequestParam(required = false,defaultValue = "")String cname){

        Page<Student> cPage =new Page<>(Integer.valueOf(page.trim()),Integer.valueOf(size.trim()));

        studentService.selectStuPage(cPage,name.trim(),cname.trim());
        if (cPage.getRecords()==null){
            return new Result(ResultEnum.DATA_NULL);
        }else {
            Map<String,Object> returnMap = new HashMap<>(6);
            returnMap.put("pages",cPage.getPages());
            returnMap.put("current",cPage.getCurrent());
            returnMap.put("size",cPage.getSize());
            returnMap.put("total",cPage.getTotal());
            returnMap.put("studentList",cPage.getRecords());
            return new Result(returnMap);
        }

    }

    @RequestMapping(value="/getPage",method = RequestMethod.GET)
    public Result<Object> getPage(){
        Page<Student> studentPage =new Page<>(1,2);
        Page<Student> studentPage1 = studentService.selectPage(studentPage, null);

        return new Result(studentPage1);
    }

    @RequestMapping(value = "/getStuP",method = RequestMethod.GET)
    public Result<Object> getStu(){

        List<Student> userList = studentService.selectPage(
                new Page<Student>(1, 10),
                new EntityWrapper<Student>().between("age",10,12).eq("class_id",2)
        ).getRecords();
        return new Result(userList);
    }
    @RequestMapping(value = "/getStuL",method = RequestMethod.GET)
    public Result<Object> getStuL(){
        List<Student> students = studentService.selectList(new EntityWrapper<Student>()
                .between("age", 12, 20)
                .eq("gender", "男")
                .eq("class_id", 2));
        return new Result(students);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Result<Object> delete(){
        studentService.delete(new EntityWrapper<Student>()
                .like("name","h")
                .eq("gender","男"));
        return new Result("删除成功");
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<Object> add(@RequestBody Student student){
        studentService.insert(student);
        return new Result("添加成功");
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<Object> update(@RequestBody Student student){
        studentService.update(student,new EntityWrapper<Student>()
                .between("age",10,12)
                .like("name","j"));
        return new Result("更新成功");
    }

    @RequestMapping(value = "/getS")
    public Result<Object> getS(){
        return null;
    }
}
