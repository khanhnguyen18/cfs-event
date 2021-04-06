package org.cfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Import({
        CfsApplication.class,
})
public class LocalCfsApplication {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(LocalCfsApplication.class);
        springApp.setAdditionalProfiles("integration_test");
        springApp.run(args);
    }

}
