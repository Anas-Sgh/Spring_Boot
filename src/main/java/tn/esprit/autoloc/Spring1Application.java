package tn.esprit.autoloc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "tn.esprit.autoloc.repository")
public class Spring1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring1Application.class, args);
    }

}
