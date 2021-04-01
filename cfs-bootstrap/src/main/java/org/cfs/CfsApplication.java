package org.cfs;

import org.cfs.config.RestConfiguration;
import org.cfs.data.config.DataJpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        RestConfiguration.class,
        DataJpaConfiguration.class,
})
public class CfsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CfsApplication.class, args);
	}

}
