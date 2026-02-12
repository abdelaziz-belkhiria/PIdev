package esprit.dialysisservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DialysisServiceApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(DialysisServiceApplication.class, args);
    }
}
