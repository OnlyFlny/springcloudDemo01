package com.springcloud.crowd.service;

import com.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept findDeptById(Long deptNo);

    public List<Dept> findAllDepts();
}
