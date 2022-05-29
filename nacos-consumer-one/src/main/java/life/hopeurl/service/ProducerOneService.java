package life.hopeurl.service;

import life.hopeurl.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  生产者1服务类
 * </p>
 *
 * @author 宋世平 email:2453332538@qq.com 2022/5/29
 **/
@FeignClient(name="nacos-provider-one")
public interface ProducerOneService {

    /**
     * 不接收任何参数
     * @return
     */
    @GetMapping(value = "/hi")
    String sayHello();


    /**
     * 服务提供方需要传入参数，多个参数，参数一定要带RequestParam
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/multipleParams")
    String multipleParams(@RequestParam String username, @RequestParam String password);

    /**
     * 服务方提供json格式的参数
     * @param userVo
     * @return
     */
    @PostMapping("/postRequestBody")
    String postRequestBody(@RequestBody UserVo userVo);

    /**
     * 服务方提供路径格式参数
     * @param message
     * @return
     */
    @GetMapping(value = "/test/{message}")
    String test(@PathVariable String message);

    /**
     * delete 请求删除数据
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteRequest")
    String deleteRequest(@RequestParam String id);

}
