package com.springcloud.crowd.service.impl;

import com.springcloud.crowd.mapper.DeptMapper;
import com.springcloud.crowd.service.DeptService;
import com.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept findDeptById(Long deptNo) {
        return deptMapper.findDeptById(deptNo);
    }

    @Override
    public List<Dept> findAllDepts() {
        return deptMapper.findAllDepts();
    }
}
