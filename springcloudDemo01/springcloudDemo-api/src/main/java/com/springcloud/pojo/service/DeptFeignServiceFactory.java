package com.springcloud.pojo.service;

import com.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DeptFeignServiceFactory implements FallbackFactory {


    @Override
    public DeptFeignService create(Throwable throwable) {
        return new DeptFeignService() {
            @Override
            public Dept findDeptById(Long deptNo) {
                return new Dept().setDeptno(deptNo).setDeptname("服务降级处理")
                        .setDb_source("meiyou shujuyuan");
            }

            @Override
            public List<Dept> findAllDepts() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
