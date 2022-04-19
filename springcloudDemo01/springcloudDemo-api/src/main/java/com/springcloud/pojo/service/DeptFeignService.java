package com.springcloud.pojo.service;

import com.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "springcloud-provider",fallbackFactory=DeptFeignServiceFactory.class)//fallbackFactory指定降级配置类
public interface DeptFeignService {

    @RequestMapping("/findDeptById/{deptNo}")
    public Dept  findDeptById(@PathVariable("deptNo") Long deptNo);

    @RequestMapping("/findAllDept")
    public List<Dept> findAllDepts();

    @RequestMapping("/addDept")
    public boolean addDept(Dept dept);
}
