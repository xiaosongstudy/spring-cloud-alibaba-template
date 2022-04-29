package life.hopeurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos服务提供者one
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProducerOneApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(NacosProducerOneApplication.class,args);
    }
}
