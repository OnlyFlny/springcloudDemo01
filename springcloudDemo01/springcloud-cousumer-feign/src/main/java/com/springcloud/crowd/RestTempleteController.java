package com.springcloud.crowd;

import com.springcloud.pojo.Dept;
import com.springcloud.pojo.service.DeptFeignService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class RestTempleteController {
    // 通过地址来指定访问单个服务位置
    // private static final String RESTTEMPLATE_URL="http://localhost:8001";
    /*
    * 如果是ribbon 多负载下，此处的URL应该是个变量，且这个变量是服务提供者的应用地址名称，不是定量，
    * 参见eureka配置
    * */
   // ribbon方式调用摸个微服务 private static final String RESTTEMPLATE_URL="http://springcloud-provider";
    /*
    * Feign 方式下是使用接口加注解的方式
    * */


    @Autowired
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/consumer/add/dept")
    public boolean add(Dept dept){
     return this.deptFeignService.addDept(dept);
    }

    @RequestMapping("/consumer/get/getDeptById/{deptno}")
    public Dept getDeptById(@PathVariable("deptno") Long deptno){
        return this.deptFeignService.findDeptById(deptno);
    }

    @RequestMapping("/consumer/get/getAllDept")
    public List<Dept> getAllDept(){
        return this.deptFeignService.findAllDepts();
    }
}
