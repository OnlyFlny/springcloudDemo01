package com.springcloud.crowd;

import com.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class RestTempleteController {
    @Autowired
    private RestTemplate restTemplate;
    // 通过地址来指定访问单个位置
    // private static final String RESTTEMPLATE_URL="http://localhost:8001";
    /*
    * 如果是ribbon 多负载下，此处的URL应该是个变量，且这个变量是服务提供者的应用地址名称，不是定量，
    * 参见eureka配置
    * */
    private static final String RESTTEMPLATE_URL="http://springcloud-provider";

    @RequestMapping(value = "/consumer/add/dept")
    public boolean add(Dept dept){
        return restTemplate.postForObject(
                RESTTEMPLATE_URL+"/addDept",dept,Boolean.class);
    }

    @RequestMapping("/consumer/get/getDeptById/{deptno}")
    public Dept getDeptById(@PathVariable("deptno") Long deptno){
        return restTemplate.getForObject(
                RESTTEMPLATE_URL+"/findDeptById/"+deptno,Dept.class);
    }

    @RequestMapping("/consumer/get/getAllDept")
    public List<Dept> getAllDept(Dept dept){
        return restTemplate.getForObject(
                RESTTEMPLATE_URL+"/findAllDept", List.class);
    }
}
