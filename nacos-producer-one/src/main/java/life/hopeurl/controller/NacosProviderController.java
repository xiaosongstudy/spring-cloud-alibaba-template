package life.hopeurl.controller;

import com.alibaba.fastjson.JSON;
import life.hopeurl.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/multipleParams")
    public String multipleParams(String username, String password) {
        return String.format("用户名为%s，密码为%s",username,password);
    }

    @PostMapping("/postRequestBody")
    public String postRequestBody(@RequestBody UserVo userVo) {
        return JSON.toJSONString(userVo);
    }

    @DeleteMapping("/deleteRequest")
    public String deleteRequest(String id) {
        return String.format("当前删除的编号为：%s", id);
    }

}
