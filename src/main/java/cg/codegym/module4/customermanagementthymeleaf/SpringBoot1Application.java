package cg.codegym.module4.customermanagementthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "cg.codegym.module4.customermanagementthymeleaf.Model")
@SpringBootApplication
public class SpringBoot1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot1Application.class, args);
    }

}
