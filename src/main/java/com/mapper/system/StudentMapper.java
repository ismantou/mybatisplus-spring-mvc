package com.mapper.system;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.model.system.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.test.annotation.Commit;
import java.util.List;


/**
 *
 * student 表数据库控制层接口
 *
 * @author huang
 */
@Commit
public interface StudentMapper extends com.baomidou.mybatisplus.mapper.BaseMapper<Student>{

    /**
     * 查询
     * @param page
     * @return
     */
    List<Student> selectMyPage(Pagination page,@Param("s") String s,@Param("c")String c);

    List<Student> selectStuList(Pagination page, Integer state);

}
