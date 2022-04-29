package life.hopeurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos服务类.<br>
 *
 * @author: shiping.song
 * @date: 2022/4/29 15:43
 **/
@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping(value = "/test/{message}")
    public String test(@PathVariable String message) {
        return "Hello Nacos Discovery " + message + " i am from port " + port;
    }

    // 从上下文中读取配置
    @GetMapping(value = "/hi")
    public String sayHi() {
        return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
    }
}
