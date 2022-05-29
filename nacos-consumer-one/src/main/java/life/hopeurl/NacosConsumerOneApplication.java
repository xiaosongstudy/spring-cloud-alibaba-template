package life.hopeurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * template .<br>
 *
 * @author: shiping.song
 * @date: 2022/4/29 17:12
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOneApplication.class,args);
    }
}
