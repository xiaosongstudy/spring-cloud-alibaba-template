package life.hopeurl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import life.hopeurl.service.ProducerOneService;
import life.hopeurl.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class NacosConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private ProducerOneService producerOneService;

    @GetMapping(value = "/test/app/name")
    @SentinelResource(value = "test", blockHandler = "handler")
    public Object test(@RequestParam(required = false,defaultValue = "测试") String test) {
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        // ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider-one");
        // String url = String.format("http://%s:%s/test/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);

        // 使用openfeign来调用服务
        log.info(producerOneService.test("我是测试数据"));
        log.info(producerOneService.multipleParams("zhangsan", "123456"));
        log.info(producerOneService.postRequestBody(new UserVo(2018, "admin", "admin123")));
        log.info(producerOneService.deleteRequest("2022"));
        return producerOneService.sayHello();
    }

    /**
     * 当触发sentinel规则时处理方案
     *
     * @param ex
     * @return
     */
    public Object handler(String test,BlockException ex) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 439);
        resp.put("msg", "您访问的太快了！！！");
        resp.put("error", ex.getMessage());
        return resp;
    }
}
