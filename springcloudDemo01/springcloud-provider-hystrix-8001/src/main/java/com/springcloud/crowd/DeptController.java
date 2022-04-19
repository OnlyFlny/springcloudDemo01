package com.springcloud.crowd;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.crowd.service.DeptService;
import com.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
   private DeptService deptService;

    @RequestMapping("/findDeptById/{deptNo}")
    @HystrixCommand(fallbackMethod = "hystrixGetDeptById")
    public Dept getDeptById(@PathVariable("deptNo") Long deptNo){
        Dept dept = deptService.findDeptById(deptNo);
        if(dept==null){
            throw new RuntimeException("id为"+deptNo+"的信息不存在，有误");
        }
        return dept;
    }
    /*
    *  服务熔断情况下要走的Hystrix备选方法
    *  */
    public Dept hystrixGetDeptById(@PathVariable("deptNo") Long deptNo){

          return new Dept().setDeptno(deptNo)
                .setDeptname("走hystrix判定的方法，改id没有对应的信息")
                .setDb_source("没有对应的数据库");

    }

}
