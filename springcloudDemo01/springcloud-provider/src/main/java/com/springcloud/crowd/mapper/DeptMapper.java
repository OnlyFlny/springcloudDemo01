package com.springcloud.crowd.mapper;

import com.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository // @Repository@Mapper一起使用防止注入mapper时爆红
public interface DeptMapper {
    public boolean addDept(Dept dept);

    public Dept findDeptById(Long deptNo);

    public  List<Dept> findAllDepts();
}
