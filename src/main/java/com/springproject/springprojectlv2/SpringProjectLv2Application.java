package com.springproject.springprojectlv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringProjectLv2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectLv2Application.class, args);
    }

}
