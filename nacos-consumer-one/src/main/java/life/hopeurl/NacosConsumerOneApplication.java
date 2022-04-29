package life.hopeurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * template .<br>
 *
 * @author: shiping.song
 * @date: 2022/4/29 17:12
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOneApplication.class,args);
    }
}
