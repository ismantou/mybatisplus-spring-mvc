package com.mapper.system;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.model.system.MyClass;
import com.model.vo.ClassVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.test.annotation.Commit;
import java.util.List;
import java.util.Map;

/**
 * @author huang
 */
@Commit
public interface ClassMapper extends com.baomidou.mybatisplus.mapper.BaseMapper<MyClass>{


    /**
     * 分页查询列表
     * @param page
     * @param wrapper
     * @return
     */
    List<Map<String,Object>> selectClassList(Pagination page,@Param("ew") Wrapper<MyClass> wrapper);

    /**
     * 分页
     * @param page
     * @return
     */
    List<Map<String,Object>> getClassList(Pagination page);
}
