package com.springcloud.crowd;

import com.springcloud.crowd.service.DeptService;
import com.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
   private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;// 实现接口来获取服务注册中的配置信息

    @RequestMapping("/addDept")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping("/findDeptById/{deptNo}")
    public  Dept findDeptById(@PathVariable("deptNo") Long deptNo){
        return deptService.findDeptById(deptNo);
    }

    @RequestMapping("/findAllDept")
    public List<Dept> addDeptMethod(){
        return deptService.findAllDepts();
    }


    // 获取注册中心的服务信息
    @RequestMapping("/info/findInfo")
    public Object discoverInfo(){
        // 获取服务列表的信息
        List<String> services = discoveryClient.getServices();
        System.out.println(services+"-------------");
        List<ServiceInstance> servicesInstances = discoveryClient
                .getInstances("SPRINGCLOUD-PROVIDER");
        for (ServiceInstance instance : servicesInstances) {
            System.out.println(
                    "HOST-------"+ instance.getHost()+"\t"+
                            "PORT------"+instance.getPort()+"\t"+
                            "URI-------"+  instance.getUri()+"\t"+
                            "ID-------"+  instance.getServiceId()
            );
        }
        return this.discoveryClient;
    }


}
