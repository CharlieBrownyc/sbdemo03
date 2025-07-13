package kr.co.brownyc.es8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class SbEs8DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbEs8DemoApplication.class, args);
    }

}
